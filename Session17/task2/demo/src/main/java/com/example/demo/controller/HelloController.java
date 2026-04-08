package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloService;

@RestController
@RequestMapping("/api")
public class HelloController {

    // 🔹 Field Injection using @Autowired
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello();
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return helloService.greetUser(name);
    }
}

