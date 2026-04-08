package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello() {
        return "Hello from Service Layer!";
    }

    public String greetUser(String name) {
        return "Hello " + name + "!";
    }
}

