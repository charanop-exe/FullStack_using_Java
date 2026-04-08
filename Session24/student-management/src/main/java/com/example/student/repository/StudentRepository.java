package com.example.student.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByDepartment(String department);

    List<Student> findByAge(int age);

}