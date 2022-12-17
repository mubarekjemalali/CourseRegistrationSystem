package com.example.courseregistrationsystem.domain.dto;

import lombok.Data;

import javax.persistence.*;


@Data
public class RegistrationDto {

    private Long id;

    private CourseOfferingDto courseOfferingDto;


}
