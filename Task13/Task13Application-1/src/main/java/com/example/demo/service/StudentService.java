package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudent(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with ID " + id + " not found"));
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> saveAll(List<Student> students) {
        return repo.saveAll(students);
    }

    public void deleteStudent(Long id) {
        Student s = getStudent(id);
        repo.delete(s);
    }

    public long getCount() {
        return repo.count();
    }
}