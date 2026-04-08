package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

    @Override
    public String sendNotification(String message) {
        return "Email sent with message: " + message;
    }
}