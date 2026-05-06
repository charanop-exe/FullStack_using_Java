package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	List<Student> getAll();
	Student getById(Long id);
	Student create(Student student);
	Student update(Long id, Student student);
	void delete(Long id);
}