package com.example.courseregistrationsystem.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class RegistrationRequestDto {

    private Long id;

    private CourseOfferingDto courseOfferingDto;

}
