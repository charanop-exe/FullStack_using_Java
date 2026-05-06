package com.sample.minigit.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sample.minigit.service.CommitService;

@RestController
public class CommitController {

    @Autowired
    private CommitService service;

    // POST /commit
    @PostMapping("/commit")
    public Map<String, String> commit(@RequestBody Map<String, String> data) {
        service.save(data);
        return Map.of("msg", "Committed");
    }

    // GET /history
    @GetMapping("/history")
    public List<?> getHistory() {
        return service.getAll();
    }
    
    @DeleteMapping("/clear")
    public String clearHistory() {
        service.clear();
        return "History cleared";
    }
}