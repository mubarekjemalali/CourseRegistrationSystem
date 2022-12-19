package com.example.courseregistrationsystem.service.dto;

import com.example.courseregistrationsystem.domain.Student;
import lombok.Data;


@Data
public class RegistrationDto {

    private Long id;

    private CourseOfferingDto courseOfferingDto;
    private Student student;


}
