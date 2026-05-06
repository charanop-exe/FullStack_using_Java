package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public String home() {
        return "Order Service Running";
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable int id) {
        try {
            String user = restTemplate.getForObject(
                "http://localhost:8081/users/" + id,
                String.class
            );

            return "Order ID: " + id + " placed by " + user;

        } catch (Exception e) {
            return "Order ID: " + id + " but User Service unavailable";
        }
    }
}