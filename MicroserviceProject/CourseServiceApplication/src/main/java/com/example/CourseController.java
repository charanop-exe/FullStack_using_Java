package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private List<Course> courses = new ArrayList<>();
    private Long idCounter = 1L;

    @PostMapping
    public Course add(@RequestBody Course c) {
        c.setId(idCounter++);
        courses.add(c);
        return c;
    }

    @GetMapping
    public List<Course> all() {
        return courses;
    }
}