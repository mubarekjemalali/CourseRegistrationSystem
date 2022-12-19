package com.example.courseregistrationsystem.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class RegistrationGroupDto {

    private Long id;
    private String track;
    private String semester;
    private String year;
    private List<StudentDto> studentDtos;

    private List<AcademicBlockDto> academicBlocks;

    private List<RegistrationEventDto> registrationEventDtos;
}
