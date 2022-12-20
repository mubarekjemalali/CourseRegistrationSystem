package com.example.courseregistrationsystem.service.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEventDto {

    private LocalDate startDate;
    private LocalDate endDate;
    private List<RegistrationGroupDto> registrationGroups;

}
