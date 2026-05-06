package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    private Long idCounter = 1L;

    @PostMapping
    public User add(@RequestBody User u) {
        u.setId(idCounter++);   // manual ID
        users.add(u);
        return u;
    }

    @GetMapping
    public List<User> all() {
        return users;
    }
}