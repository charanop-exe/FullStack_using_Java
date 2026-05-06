package com.sample.aiprompt.model;

public class PromptResponse {

    private String output;
    private int score;

    public PromptResponse(String output, int score) {
        this.output = output;
        this.score = score;
    }

    public String getOutput() {
        return output;
    }

    public int getScore() {
        return score;
    }
}