package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.domain.RegistrationEvent;
import com.example.courseregistrationsystem.domain.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationEventController {
    @Autowired
    private RegistrationEventService registrationEventService;


    @GetMapping("/registration-events/latest")
    public ResponseEntity<RegistrationEventDto> getLatestRegistrationEvent() {
        return ResponseEntity.ok().body(registrationEventService.getLatestRegistrationEvent());

    }

}
