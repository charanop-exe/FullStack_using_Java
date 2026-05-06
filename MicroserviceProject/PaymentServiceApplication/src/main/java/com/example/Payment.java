package com.example;

public class Payment {

    private Long userId;
    private Long courseId;
    private double amount;

    public Payment() {}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}