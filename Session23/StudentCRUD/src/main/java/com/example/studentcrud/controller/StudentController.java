package com.example.studentcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    // CREATE
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        Optional<Student> student = repository.findById(id);
        return student.orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student newStudent) {

        Optional<Student> optional = repository.findById(id);

        if(optional.isPresent()) {
            Student student = optional.get();
            student.setName(newStudent.getName());
            student.setEmail(newStudent.getEmail());
            return repository.save(student);
        }
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        repository.deleteById(id);
        return "Student Deleted Successfully";
    }
}