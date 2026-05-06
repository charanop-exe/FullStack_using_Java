package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Create
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    // Read All
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getEmployees();
    }

    // Read By ID
    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable Integer empId) {
        return service.getEmployeeById(empId);
    }
    
    @GetMapping("/count")
    public long getEmployeeCount() {
        return service.getEmployees().size();
    }

    // Update
    @PutMapping("/{empId}")
    public Employee updateEmployee(@PathVariable Integer empId,
                                   @RequestBody Employee employee) {
        return service.updateEmployee(empId, employee);
    }

    // Delete
    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable Integer empId) {
        return service.deleteEmployee(empId);
    }
}