package com.example.courseregistrationsystem.domain.dto;

import com.example.courseregistrationsystem.domain.Student;
import lombok.Data;

import javax.persistence.*;


@Data
public class RegistrationDto {

    private Long id;

    private CourseOfferingDto courseOfferingDto;
    private Student student;


}
