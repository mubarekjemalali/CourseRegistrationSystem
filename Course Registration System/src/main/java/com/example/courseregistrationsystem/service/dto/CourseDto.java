package com.example.courseregistrationsystem.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDto {

    private Long id;
    private String code;
    private String courseName;
    private String description;

    private List<CourseDto> preRequisites;


}
