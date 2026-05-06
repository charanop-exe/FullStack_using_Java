package com.example;

public class Enrollment {

    private Long userId;
    private Long courseId;

    public Enrollment() {}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
}