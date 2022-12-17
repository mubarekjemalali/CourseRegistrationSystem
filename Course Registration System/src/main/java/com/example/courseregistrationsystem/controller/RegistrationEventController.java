package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.domain.RegistrationEvent;
import com.example.courseregistrationsystem.domain.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationEventController {
    @Autowired
    private RegistrationEventService registrationEventService;

    // add registration event
    @PostMapping
    public ResponseEntity<RegistrationEventDto> createRegistrationEvent(@RequestBody RegistrationEventDto registrationEventDto) {
        return ResponseEntity.ok().body(registrationEventService.createRegistrationEvent(registrationEventDto));
    }
    // get all registration events
    @GetMapping
    public ResponseEntity<List<RegistrationEventDto>> getAllRegistrationEvents() {
//        return ResponseEntity.ok().body(registrationEventService.getAllRegistrationEvents());
        return null;

    }

    // update registration event
    @PutMapping
    public ResponseEntity<RegistrationEventDto> updateRegistrationEvent(@RequestBody RegistrationEventDto registrationEventDto) {
        return ResponseEntity.ok().body(registrationEventService.updateRegistrationEvent(registrationEventDto));
    }

    // delete registration event
    @DeleteMapping
    public ResponseEntity<String> deleteRegistrationEvent(@RequestBody RegistrationEventDto registrationEventDto) {
        return ResponseEntity.ok().body("Registration event deleted successfully");
    }

}
