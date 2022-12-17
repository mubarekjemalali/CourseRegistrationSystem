package com.example.courseregistrationsystem.domain.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class RegistrationGroupDto {

    private Long id;

    private List<StudentDto> studentDtos;

    private List<AcademicBlockDto> academicBlocks;

    private List<RegistrationEventDto> registrationEventDtos;
}
