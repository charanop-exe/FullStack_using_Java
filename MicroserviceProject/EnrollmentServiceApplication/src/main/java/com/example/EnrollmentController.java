package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/enroll")
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @PostMapping
    public Enrollment enroll(@RequestBody Enrollment e) {
        return service.enroll(e);
    }

    @GetMapping
    public List<Enrollment> all() {
        return service.getAll();
    }
}