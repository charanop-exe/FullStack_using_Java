package com.example.mvcdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvcdemo.model.Employee;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public Employee getEmployee(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam double salary) {

        return new Employee(id, name, salary);
    }
}