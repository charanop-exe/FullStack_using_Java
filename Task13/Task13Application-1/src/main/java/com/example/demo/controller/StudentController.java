package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("student", new Student());
        model.addAttribute("totalEntries", service.getCount());
        return "students";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult result,
                             Model model) {

        if (result.hasErrors()) {
            model.addAttribute("students", service.getAllStudents());
            model.addAttribute("totalEntries", service.getCount());
            return "students";
        }

        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudent(id));
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("totalEntries", service.getCount());
        return "students";
    }
}