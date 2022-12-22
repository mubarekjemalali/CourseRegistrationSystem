package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.service.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.service.dto.RegistrationEventWOStudentList;

import java.util.List;

public interface RegistrationEventService {

    RegistrationEventDto createRegistrationEvent(RegistrationEventDto registrationEventDto);

    List<RegistrationEventDto> getAllRegistrationEvents();

    RegistrationEventDto updateRegistrationEvent(RegistrationEventDto registrationEventDto, long id);

    void deleteRegistrationEvent(long id);


    RegistrationEventDto getLatestRegistrationEvent();

//    void process(int id);

    void addRegistrationGroupToRegistrationEvent(long registration_event_id, long registration_group_id);

    RegistrationEventWOStudentList findLatestByStudentId(long id);

    void process(long id);
}
