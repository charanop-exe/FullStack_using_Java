package com.sample.vibecloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.sample.vibecloud.model.*;
import com.sample.vibecloud.service.VibeService;

@RestController
public class VibeController {

    @Autowired
    private VibeService service;

    // POST /generate
    @PostMapping("/generate")
    public PromptResponse generate(@RequestBody PromptRequest request) {
        return service.process(request.getPrompt());
    }

    // GET /history
    @GetMapping("/history")
    public List<PromptHistory> history() {
        return service.getHistory();
    }
}