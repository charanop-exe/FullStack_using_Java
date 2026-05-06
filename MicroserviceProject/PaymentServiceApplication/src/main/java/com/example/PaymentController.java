package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public String pay(@RequestBody Payment p) {
        return service.processPayment(p);
    }

    @GetMapping
    public List<Payment> all() {
        return service.getAllPayments();
    }
}