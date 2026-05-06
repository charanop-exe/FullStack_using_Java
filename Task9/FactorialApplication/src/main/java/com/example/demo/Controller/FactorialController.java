package com.example.demo.Controller;

import com.example.demo.Service.FactorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FactorialController {

    @Autowired
    private FactorialService factorialService;

    @GetMapping("/")
    public String showForm() {
        return "factorial";
    }

    @PostMapping("/calculate")
    public String calculateFactorial(@RequestParam("number") int number, Model model) {
        long result = factorialService.calculateFactorial(number);
        model.addAttribute("number", number);
        model.addAttribute("result", result);
        return "factorial";
    }
}