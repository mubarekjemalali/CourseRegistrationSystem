package com.example.courseregistrationsystem.service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RegistrationEventDto {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    
    private List<RegistrationGroupDto> registrationGroupDtos;

}
