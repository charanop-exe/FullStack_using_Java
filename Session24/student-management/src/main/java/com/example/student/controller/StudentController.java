package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/department/{dept}")
    public List<Student> getByDepartment(@PathVariable String dept) {
        return studentRepository.findByDepartment(dept);
    }

    @GetMapping("/age/{age}")
    public List<Student> getByAge(@PathVariable int age) {
        return studentRepository.findByAge(age);
    }
}