package com.example;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PaymentService {

    private List<Payment> payments = new ArrayList<>();

    public String processPayment(Payment p) {
        payments.add(p);
        return "✅ Payment Successful for Course " + p.getCourseId();
    }

    public List<Payment> getAllPayments() {
        return payments;
    }
}