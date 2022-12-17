package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.domain.RegistrationEvent;
import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.domain.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.repo.RegistrationEventRepository;
import com.example.courseregistrationsystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentRegistrationEventController {

    @Autowired
    private RegistrationEventRepository registrationEventRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    ModelMapper modelMapper;

   @GetMapping("/registration-event/latest")
    public RegistrationEventDto getLatestRegistrationEvent() {
       // TODO: get the student from the user object
        return studentService.getRegistrationEvent();

    }

}
