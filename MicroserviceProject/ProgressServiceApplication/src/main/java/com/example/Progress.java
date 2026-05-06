package com.example;

public class Progress {

    private Long userId;
    private Long courseId;
    private int completion; // percentage (0–100)

    public Progress() {}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public int getCompletion() { return completion; }
    public void setCompletion(int completion) { this.completion = completion; }
}