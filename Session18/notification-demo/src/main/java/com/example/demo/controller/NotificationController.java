package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.NotificationService;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private NotificationService notificationService;

    @Autowired
    public NotificationController(
            @Qualifier("emailService") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public String sendNotification(@RequestParam String message) {
        return notificationService.sendNotification(message);
    }
}
