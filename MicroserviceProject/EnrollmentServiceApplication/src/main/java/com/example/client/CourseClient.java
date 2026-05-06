package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseClient {

    @GetMapping("/courses")
    Object getCourses();
}