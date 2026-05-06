package com.sample.cicd.controller;

import com.sample.cicd.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PipelineController {

    @Autowired
    private PipelineService service;

    // RUN PIPELINE
    @PostMapping("/run")
    public Map<String, String> runPipeline() throws InterruptedException {
        service.runPipeline();
        return Map.of("msg", "Pipeline executed");
    }

    // GET LOGS
    @GetMapping("/logs")
    public List<String> getLogs() {
        return service.getLogs();
    }
}