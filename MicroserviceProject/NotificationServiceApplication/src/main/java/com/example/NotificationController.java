package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public String send(@RequestBody Notification n) {
        return service.send(n.getMessage());
    }

    @GetMapping
    public List<String> all() {
        return service.getAll();
    }
}