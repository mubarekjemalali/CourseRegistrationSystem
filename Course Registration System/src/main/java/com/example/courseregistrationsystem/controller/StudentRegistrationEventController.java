package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.repo.RegistrationEventRepository;
import com.example.courseregistrationsystem.service.StudentService;
import com.example.courseregistrationsystem.service.dto.RegistrationEventDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration-events")
public class StudentRegistrationEventController {

    @Autowired
    private RegistrationEventRepository registrationEventRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    ModelMapper modelMapper;

//   @GetMapping("/latest")
//    public RegistrationEventDto getLatestRegistrationEvent() {
//       // TODO: get the student from the user object
//       System.out.println("latest called");
//        return studentService.getRegistrationEvent();
//
//    }

}
