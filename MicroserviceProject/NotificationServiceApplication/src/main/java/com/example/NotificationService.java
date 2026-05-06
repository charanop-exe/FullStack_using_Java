package com.example;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NotificationService {

    private List<String> messages = new ArrayList<>();

    public String send(String msg) {
        messages.add(msg);
        return "📩 Notification Sent: " + msg;
    }

    public List<String> getAll() {
        return messages;
    }
}