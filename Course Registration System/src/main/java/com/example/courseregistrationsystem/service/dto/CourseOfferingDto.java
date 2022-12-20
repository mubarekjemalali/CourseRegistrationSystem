package com.example.courseregistrationsystem.service.dto;

import com.example.courseregistrationsystem.domain.Course;
import com.example.courseregistrationsystem.domain.Registration;
import com.example.courseregistrationsystem.domain.RegistrationRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseOfferingDto {

    private Long id;
    private String code;

    private FacultyDto facultyDto;
    @JsonBackReference
    private AcademicBlockDto academicBlock;
    private CourseDto course;
    @JsonManagedReference
    private List<RegistrationDto> registrations;
    @JsonManagedReference
    private List<RegistrationRequestDto> registrationRequests;


}
