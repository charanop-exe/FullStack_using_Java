package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    private StudentService service;

    // Create Student
    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student) {
        Student saved = service.saveStudent(student);
        return ResponseEntity.ok(Map.of(
                "message", "Student added successfully",
                "data", saved,
                "totalEntries", service.getCount()
        ));
    }

    // Bulk Insert
    @PostMapping("/bulk")
    public ResponseEntity<?> addStudents(@RequestBody List<Student> students) {
        List<Student> saved = service.saveAll(students);
        return ResponseEntity.ok(Map.of(
                "message", "Students added successfully",
                "data", saved,
                "totalEntries", service.getCount()
        ));
    }

    // Get all
    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudent(id));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        student.setId(id);
        return ResponseEntity.ok(service.saveStudent(student));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok(Map.of(
                "message", "Student deleted successfully",
                "totalEntries", service.getCount()
        ));
    }

    // Count
    @GetMapping("/count")
    public ResponseEntity<?> getStudentCount() {
        return ResponseEntity.ok(Map.of("totalEntries", service.getCount()));
    }
}