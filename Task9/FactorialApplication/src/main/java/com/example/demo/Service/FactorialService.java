package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class FactorialService {

    public long calculateFactorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}