package com.example.courseregistrationsystem.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Long id;
    private String code;
    private String courseName;
    private String description;

    private List<CourseDto> preRequisites;


}
