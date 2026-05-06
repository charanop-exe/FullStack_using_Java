package com.sample.vibecloud.service;

import java.util.*;
import org.springframework.stereotype.Service;

import com.sample.vibecloud.model.*;

@Service
public class VibeService {

    private List<PromptHistory> history = new ArrayList<>();

    public PromptResponse process(String prompt) {

        String output = "";
        int score = 5;

        // store prompt history
        history.add(new PromptHistory(prompt));

        if (prompt.toLowerCase().contains("rest")) {

            output = "app.get('/api', (req,res)=>res.send('API running'));";
            score = 7;

        } else if (prompt.toLowerCase().contains("cloud")) {

            output = "Deploy using AWS EC2:\n" +
                     "1. Launch instance\n" +
                     "2. Install Node.js\n" +
                     "3. Run app";
            score = 8;

        } else if (prompt.toLowerCase().contains("security")) {

            output = "Use HTTPS, JWT authentication, and firewall rules";
            score = 9;
        }

        // dynamic score boost
        score += Math.min(history.size(), 2);

        return new PromptResponse(output, score);
    }

    public List<PromptHistory> getHistory() {
        return history;
    }
}