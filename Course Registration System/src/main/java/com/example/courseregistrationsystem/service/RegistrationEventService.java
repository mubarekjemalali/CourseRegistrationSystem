package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.dto.RegistrationEventDto;

public interface RegistrationEventService {
    RegistrationEventDto getLatestRegistrationEvent();
}
