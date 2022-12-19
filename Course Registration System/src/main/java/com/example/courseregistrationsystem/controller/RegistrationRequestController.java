package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.domain.dto.RegistrationRequestDto;
import com.example.courseregistrationsystem.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationRequestController {

    @Autowired
    private RegistrationRequestService registrationRequestService;

    @PostMapping("/api/v1/registration-requests/")
    public void save(@RequestBody RegistrationRequestDto registrationRequestDto) {
        registrationRequestService.save(registrationRequestDto);
    }

}
