package com.example.demo;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EmployeeRepository {

    private Map<Integer, Employee> data = new HashMap<>();

    public EmployeeRepository() {
        data.put(101, new Employee(101, "Ravi", "IT"));
        data.put(102, new Employee(102, "Anita", "HR"));
        data.put(103, new Employee(103, "Kiran", "Finance"));
    }

    public Employee findById(int id) {
        return data.get(id);
    }
}