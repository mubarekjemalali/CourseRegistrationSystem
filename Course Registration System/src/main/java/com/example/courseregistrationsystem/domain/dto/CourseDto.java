package com.example.courseregistrationsystem.domain.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class CourseDto {

    private Long id;
    private String code;
    private String courseName;
    private String description;

    private List<CourseDto> preRequisites;


}
