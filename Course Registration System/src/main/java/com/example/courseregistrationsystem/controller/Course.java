package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.service.CourseService;
import com.example.courseregistrationsystem.service.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
public class Course {

    @Autowired
    private CourseService courseService;
    // create course
    @PostMapping("")
    public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto courseDto){
        return ResponseEntity.ok().body(courseService.createCourse(courseDto));
    }


}
