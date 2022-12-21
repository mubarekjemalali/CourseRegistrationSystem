package com.example.courseregistrationsystem.controller;


import com.example.courseregistrationsystem.service.RegistrationRequestService;
import com.example.courseregistrationsystem.service.dto.CourseOfferingDto;
import com.example.courseregistrationsystem.service.dto.RegistrationRequestDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration-requests/")
public class RegistrationRequestController {

    @Autowired
    private RegistrationRequestService registrationRequestService;

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private CourseOfferingClient courseOfferingClient;

//    @PostMapping("")
//    public void save(@RequestBody RegistrationRequestDto registrationRequestDto) {
//        registrationRequestService.save(registrationRequestDto);
//    }


    // add registration request,  using feign client
    @PostMapping("/{studentId}/{courseOfferingId}")
    public ResponseEntity<RegistrationRequestDto> addRegistrationRequest(@RequestBody RegistrationRequestDto registrationRequestDto, @PathVariable long courseOfferingId, @PathVariable long studentId) {
        try {
            return ResponseEntity.ok(studentClient.addRegistrationRequest(registrationRequestDto, courseOfferingId, studentId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }



}
