package com.example.ordersystem.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.example.ordersystem.model.PaymentResponse;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping("/process")
    public PaymentResponse processPayment() {

        String paymentId = UUID.randomUUID().toString().substring(0, 14);

        return new PaymentResponse(paymentId, "SUCCESS");
    }
}