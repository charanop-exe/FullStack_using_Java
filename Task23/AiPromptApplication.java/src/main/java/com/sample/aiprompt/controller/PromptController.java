package com.sample.aiprompt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sample.aiprompt.model.PromptRequest;
import com.sample.aiprompt.model.PromptResponse;
import com.sample.aiprompt.service.PromptService;

@RestController
public class PromptController {

    @Autowired
    private PromptService service;

    // POST /generate
    @PostMapping("/generate")
    public PromptResponse generate(@RequestBody PromptRequest request) {
        return service.processPrompt(request.getPrompt());
    }
}