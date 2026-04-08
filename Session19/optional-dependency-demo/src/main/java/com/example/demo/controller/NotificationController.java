package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.NotificationService;
import com.example.demo.service.PromotionService;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private NotificationService notificationService;

    // Optional dependency injection
    @Autowired(required = false)
    private PromotionService promotionService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public String sendNotification(@RequestParam String message) {

        String result = notificationService.sendNotification(message);

        // Handle null safely
        if (promotionService != null) {
            result += promotionService.getPromotionMessage();
        }

        return result;
    }
}