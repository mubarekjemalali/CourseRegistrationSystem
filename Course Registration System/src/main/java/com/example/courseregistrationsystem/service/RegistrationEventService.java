package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.service.dto.RegistrationEventDto;

import java.util.List;

public interface RegistrationEventService {

    RegistrationEventDto createRegistrationEvent(RegistrationEventDto registrationEventDto);

    List<RegistrationEventDto> getAllRegistrationEvents();

    RegistrationEventDto updateRegistrationEvent(RegistrationEventDto registrationEventDto);

    void deleteRegistrationEvent(RegistrationEventDto registrationEventDto);

    void process(int id);

}
