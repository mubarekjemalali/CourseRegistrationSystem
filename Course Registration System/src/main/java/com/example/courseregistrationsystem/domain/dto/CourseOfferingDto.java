package com.example.courseregistrationsystem.domain.dto;

import com.example.courseregistrationsystem.domain.Course;
import com.example.courseregistrationsystem.domain.Registration;
import com.example.courseregistrationsystem.domain.RegistrationRequest;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
public class CourseOfferingDto {

    private Long id;
    private String code;

    private FacultyDto facultyDto;
    private AcademicBlockDto academicBlock;
    private CourseDto course;
    private List<RegistrationDto> registrations;
    private List<RegistrationRequestDto> registrationRequests;
}
