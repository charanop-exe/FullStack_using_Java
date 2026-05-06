package com.sample.cloudapp.controller;

import com.sample.cloudapp.service.CloudService;
import com.sample.cloudapp.model.CostRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CloudController {

    @Autowired
    private CloudService service;

    // GET /services/{provider}
    @GetMapping("/services/{provider}")
    public Map<String, String> getServices(@PathVariable String provider) {
        return service.getServices(provider);
    }

    // POST /cost
    @PostMapping("/cost")
    public Map<String, Double> calculate(@RequestBody CostRequest request) {
        double cost = service.calculateCost(
                request.getProvider(),
                request.getHours(),
                request.getStorage()
        );

        return Map.of("cost", Double.parseDouble(String.format("%.2f", cost)));
    }
}