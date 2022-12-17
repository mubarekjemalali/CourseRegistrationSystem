package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.RegistrationEvent;
import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.domain.dto.RegistrationEventDto;

public interface StudentService {
    RegistrationEventDto getRegistrationEvent();
}
