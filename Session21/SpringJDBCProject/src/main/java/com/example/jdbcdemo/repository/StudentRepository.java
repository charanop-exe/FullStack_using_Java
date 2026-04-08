package com.example.jdbcdemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jdbcdemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}