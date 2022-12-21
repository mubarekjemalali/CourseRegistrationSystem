package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.service.dto.RegistrationRequestDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="courseRegistrationSystem", url = "http://localhost:8080")
interface StudentClient {
    @GetMapping("/students")
    public List<StudentDto> getStudents();
    @GetMapping("/students/{id}")
    public StudentDto getStudent(@PathVariable long id);
    @PostMapping("students/{studentId}/{courseOfferingId}")
    public RegistrationRequestDto addRegistrationRequest(@RequestBody RegistrationRequestDto registrationRequestDto, @PathVariable long courseOfferingId, @PathVariable long studentId);
}

