package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.Course;
import com.example.courseregistrationsystem.repo.CourseRepository;
import com.example.courseregistrationsystem.service.CourseService;
import com.example.courseregistrationsystem.service.dto.CourseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseRepository.save(mapper.map(courseDto, Course.class));
        return mapper.map(course, CourseDto.class);
    }


}
