package com.example.pagination.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import com.example.pagination.entity.Student;
import com.example.pagination.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    // CREATE
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return repository.save(student);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){

        Optional<Student> student = repository.findById(id);

        return student.orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,
                                 @RequestBody Student newStudent){

        Optional<Student> optional = repository.findById(id);

        if(optional.isPresent()){
            Student student = optional.get();
            student.setName(newStudent.getName());
            student.setEmail(newStudent.getEmail());
            student.setDepartment(newStudent.getDepartment());
            student.setAge(newStudent.getAge());

            return repository.save(student);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){

        repository.deleteById(id);

        return "Student Deleted Successfully";
    }

    // SEARCH BY DEPARTMENT
    @GetMapping("/department/{dept}")
    public List<Student> getByDepartment(@PathVariable String dept){

        return repository.findByDepartment(dept);
    }

    // SEARCH BY AGE
    @GetMapping("/age/{age}")
    public List<Student> getByAge(@PathVariable int age){

        return repository.findByAge(age);
    }

    // SORTING
    @GetMapping("/sort/{field}")
    public List<Student> sortStudents(@PathVariable String field){

        return repository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    // PAGINATION
    @GetMapping("/pagination")
    public Page<Student> pagination(@RequestParam int page,
                                    @RequestParam int size){

        Pageable pageable = PageRequest.of(page,size);

        return repository.findAll(pageable);
    }
}