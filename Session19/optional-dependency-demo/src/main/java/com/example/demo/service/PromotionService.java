package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class PromotionService {

    public String getPromotionMessage() {
        return " | Special Promotion Applied!";
    }
}