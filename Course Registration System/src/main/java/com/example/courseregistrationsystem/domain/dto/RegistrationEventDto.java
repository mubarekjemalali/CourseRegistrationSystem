package com.example.courseregistrationsystem.domain.dto;

import com.example.courseregistrationsystem.domain.RegistrationGroup;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.List;

public class RegistrationEventDto {

    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<RegistrationGroupDto> registrationGroupDtos;

}
