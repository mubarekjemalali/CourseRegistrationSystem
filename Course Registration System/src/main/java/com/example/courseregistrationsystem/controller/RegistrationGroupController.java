package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.service.RegistrationGroupService;
import com.example.courseregistrationsystem.service.dto.RegistrationGroupDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration-groups")
public class RegistrationGroupController {
    @Autowired
    private RegistrationGroupService registrationGroupService;

    @Autowired
    private StudentClient studentClient;


    // create registration group
    @PostMapping("")
    public ResponseEntity<RegistrationGroupDto> createRegistrationGroup(@RequestBody RegistrationGroupDto registrationGroupDto) {
        return ResponseEntity.ok().body(registrationGroupService.createRegistrationGroup(registrationGroupDto));
    }

    // get registration group by id
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationGroupDto> getRegistrationGroup(@PathVariable long id) {

        try {
            return ResponseEntity.ok().body(registrationGroupService.getRegistrationGroup(id));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }


    // delete registration group
    @PostMapping("/{id}")
    public ResponseEntity<String> deleteRegistrationGroup( @PathVariable long id) {
        try {
            return ResponseEntity.ok().body(registrationGroupService.deleteRegistrationGroup(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration Group not found");
        }

    }


    // add list of students to registration group
    // get list of students using feign client
    @PutMapping("/{id}")
    public ResponseEntity<String> addStudentsToRegistrationGroup(@PathVariable long id) {
        // call student controller to get list of students
        List<StudentDto> studentDtos = studentClient.getStudents();
        try {
            registrationGroupService.addStudentsToRegistrationGroup(id, studentDtos);
            return ResponseEntity.ok().body("Students added to registration group successfully");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration Group not found");
        }
    }

}
