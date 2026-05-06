package com.example;

import org.springframework.stereotype.Service;

import com.example.client.CourseClient;
import com.example.client.UserClient;

import java.util.*;

@Service
public class EnrollmentService {

    private List<Enrollment> enrollments = new ArrayList<>();

    private final UserClient userClient;
    private final CourseClient courseClient;

    public EnrollmentService(UserClient userClient, CourseClient courseClient) {
        this.userClient = userClient;
        this.courseClient = courseClient;
    }

    public Enrollment enroll(Enrollment e) {
        userClient.getUsers();
        courseClient.getCourses();

        enrollments.add(e);
        return e;
    }

    public List<Enrollment> getAll() {
        return enrollments;
    }
}