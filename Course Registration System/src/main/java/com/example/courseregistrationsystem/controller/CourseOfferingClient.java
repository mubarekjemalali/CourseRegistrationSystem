package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.service.dto.CourseOfferingDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="courseRegistrationSystem1", url = "http://localhost:8080")
public interface CourseOfferingClient {
    @GetMapping("/course-offering/{id}")
    public CourseOfferingDto getCourseOffering(@PathVariable long id);

}
