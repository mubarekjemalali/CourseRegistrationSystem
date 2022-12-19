package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.service.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController("/api/v1/registration-events/")

public class RegistrationEventController {
    @Autowired
    private RegistrationEventService registrationEventService;

    // add registration event
    @PostMapping("/")
    public ResponseEntity<RegistrationEventDto> createRegistrationEvent(@RequestBody RegistrationEventDto registrationEventDto) {
        System.out.println("registration event called");
        return ResponseEntity.ok().body(registrationEventService.createRegistrationEvent(registrationEventDto));
    }
    //     get all registration events
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

    @PutMapping("/{id}")
    public void processed(@PathVariable int id, @RequestParam(required = false) boolean processed) {
        if (processed) {
            // assign course to students
        }
    }

    // delete registration event
    @DeleteMapping
    public ResponseEntity<String> deleteRegistrationEvent(@RequestBody RegistrationEventDto registrationEventDto) {
        return ResponseEntity.ok().body("Registration event deleted successfully");
    }

    // get registration event by id
    @GetMapping("/latest")
    public ResponseEntity<String> getRegistrationEventById() {
        return ResponseEntity.ok().body("get the registration event latest");
    }

}
