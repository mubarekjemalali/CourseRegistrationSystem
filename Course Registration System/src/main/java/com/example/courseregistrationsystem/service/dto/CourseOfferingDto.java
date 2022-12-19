package com.example.courseregistrationsystem.service.dto;

import lombok.Data;

import java.util.List;


@Data
public class CourseOfferingDto {

    private Long id;
    private String code;

    private FacultyDto facultyDto;

    private AcademicBlockDto academicBlock;

    private List<CourseDto> cours;

    private RegistrationDto registrations;

    private RegistrationRequestDto registrationRequestsDto;
}
