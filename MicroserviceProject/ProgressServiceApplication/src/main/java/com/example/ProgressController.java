package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService service;

    public ProgressController(ProgressService service) {
        this.service = service;
    }

    @PostMapping
    public Progress save(@RequestBody Progress p) {
        return service.saveProgress(p);
    }

    @GetMapping
    public List<Progress> all() {
        return service.getAll();
    }
}