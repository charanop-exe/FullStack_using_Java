package com.sample.cicd.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PipelineService {

    private List<String> logs = new ArrayList<>();

    public List<String> getLogs() {
        return logs;
    }

    public void runPipeline() throws InterruptedException {

        logs = new ArrayList<>();

        logs.add("Code Checkout...");
        delay();

        logs.add("Build Started...");
        delay();

        logs.add("Running Tests...");
        delay();

        logs.add("Tests Passed");
        delay();

        logs.add("Deploying Application...");
        delay();

        logs.add("Deployment Successful!");
    }

    private void delay() throws InterruptedException {
        Thread.sleep(1000); // 1 second delay
    }
}