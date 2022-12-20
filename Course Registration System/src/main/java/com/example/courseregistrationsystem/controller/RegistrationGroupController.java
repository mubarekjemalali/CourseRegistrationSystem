package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.service.RegistrationGroupService;
import com.example.courseregistrationsystem.service.dto.RegistrationGroupDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration-groups")
public class RegistrationGroupController {
    @Autowired
    private RegistrationGroupService registrationGroupService;

    // create registration group
    @PostMapping("")
    public ResponseEntity<RegistrationGroupDto> createRegistrationGroup(@RequestBody RegistrationGroupDto registrationGroupDto) {
        return ResponseEntity.ok().body(registrationGroupService.createRegistrationGroup(registrationGroupDto));
    }

    // get registration group by id
    @GetMapping("/{id}")
    public void getRegistrationGroup(@RequestParam long id) {
        registrationGroupService.getRegistrationGroup(id);
    }

    // delete registration group
    @PostMapping("/{id}")
    public void deleteRegistrationGroup(@RequestParam long id) {
        registrationGroupService.deleteRegistrationGroup(id);
    }

    // add list of students to registration group
    @PutMapping("/{id}")
    public void addStudentsToRegistrationGroup(@RequestParam long id, @RequestBody List<StudentDto> studentDtos) {
        registrationGroupService.addStudentsToRegistrationGroup(id, studentDtos);
    }
}
