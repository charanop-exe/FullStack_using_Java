package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Create
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Read All
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    // Read By ID
    public Employee getEmployeeById(Integer empId) {
        return repository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));
    }

    // Read By First Name
    public Employee getEmployeeByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    // Update
    public Employee updateEmployee(Integer empId, Employee employee) {

        Employee existingEmployee = repository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        return repository.save(existingEmployee);
    }

    // Delete
    public String deleteEmployee(Integer empId) {

        Employee employee = repository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));

        repository.delete(employee);

        return "Employee deleted successfully with id: " + empId;
    }
}