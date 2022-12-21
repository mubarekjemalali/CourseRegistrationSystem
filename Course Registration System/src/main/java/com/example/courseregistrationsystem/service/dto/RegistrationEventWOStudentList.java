package com.example.courseregistrationsystem.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEventWOStudentList {

    private LocalDate startDate;
    private LocalDate endDate;
    private List<RegistrationGroupDto> registrationGroups;
    private String status;

}
