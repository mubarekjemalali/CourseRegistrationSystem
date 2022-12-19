package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.repo.RegistrationEventRepository;
import com.example.courseregistrationsystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRegistrationEventController {

    @Autowired
    private RegistrationEventRepository registrationEventRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    ModelMapper modelMapper;

//   @GetMapping("/registration-event/latest")
//    public RegistrationEventDto getLatestRegistrationEvent() {
//       // TODO: get the student from the user object
//        return studentService.getRegistrationEvent();
//
//    }

}
