package com.example.jdbcdemo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jdbcdemo.entity.Student;
import com.example.jdbcdemo.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}