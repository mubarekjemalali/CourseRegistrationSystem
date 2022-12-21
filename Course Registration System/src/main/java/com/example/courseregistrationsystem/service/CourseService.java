package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.Course;
import com.example.courseregistrationsystem.service.dto.CourseDto;

import java.util.Map;
import java.util.Optional;

public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);

    Optional<CourseDto> findById(long courseId);
}
