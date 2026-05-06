package com.sample.aiprompt.service;

import org.springframework.stereotype.Service;
import com.sample.aiprompt.model.PromptResponse;

@Service
public class PromptService {

    public PromptResponse processPrompt(String prompt) {

        String output;
        int score = 5;

        if (prompt.toLowerCase().contains("code")) {
            output = "function greet() {\n" +
                     "    console.log(\"Hello from AI!\");\n" +
                     "}";
            score = 9;

        } else if (prompt.toLowerCase().contains("cloud")) {
            output = "AWS EC2 Config:\n" +
                     "- Instance: t2.micro\n" +
                     "- Region: us-east-1";
            score = 8;

        } else {
            output = "Basic AI response generated.";
            score = 5;
        }

        return new PromptResponse(output, score);
    }
}