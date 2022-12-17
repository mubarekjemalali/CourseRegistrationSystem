package com.example.courseregistrationsystem.domain.dto;

import lombok.Data;

import javax.persistence.*;
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
