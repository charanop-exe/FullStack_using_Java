package com.example.demo.service;


import org.springframework.stereotype.Service;

@Service("smsService")
public class SMSNotificationService implements NotificationService {

    @Override
    public String sendNotification(String message) {
        return "SMS sent with message: " + message;
    }
}
