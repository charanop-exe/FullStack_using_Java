package com.example.ordersystem.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ordersystem.model.PaymentResponse;

@Service
public class OrderService {

    public String createOrder() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081/payment/process";

        PaymentResponse paymentResponse =
                restTemplate.postForObject(url, null, PaymentResponse.class);

        if(paymentResponse.getStatus().equals("SUCCESS")) {
            return "Order Confirmed. Payment ID: " + paymentResponse.getPaymentId();
        }

        return "Payment Failed. Order Cancelled.";
    }
}