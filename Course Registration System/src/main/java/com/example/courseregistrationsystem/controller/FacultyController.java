package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.service.FacultyService;
import com.example.courseregistrationsystem.service.dto.FacultyDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    //add faculty
    @PostMapping("")
    public ResponseEntity<FacultyDto> createFaculty(@RequestBody FacultyDto facultyDto) {
        return ResponseEntity.ok().body(facultyService.addFaculty(facultyDto));
    }
    // add student


    // get faculty by id
    @GetMapping("/{id}")
    public ResponseEntity<FacultyDto> getFacultyById(@PathVariable long id) {
        try {
            return ResponseEntity.ok().body(facultyService.getFacultyById(id));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


    //get all faculties
    @GetMapping("")
    public ResponseEntity<List<FacultyDto>> getAllFaculties() {
        return ResponseEntity.ok().body(facultyService.getAllFaculties());
    }

    //delete faculty
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable long id) {
        try {
            facultyService.deleteFaculty(id);
            return ResponseEntity.ok().body("Faculty deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Faculty not found");
        }

    }


}
