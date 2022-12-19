package com.example.courseregistrationsystem.controller;


import com.example.courseregistrationsystem.service.RegistrationService;
import com.example.courseregistrationsystem.service.dto.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1")
public class UserRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/students/{id}/registrations")
    public List<RegistrationDto> findAllByStudent_id(@PathVariable long id) {
        return registrationService.findAllByStudent_Id(id);
    }

}
