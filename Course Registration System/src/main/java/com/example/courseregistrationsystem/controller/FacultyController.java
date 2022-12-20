package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.service.FacultyService;
import com.example.courseregistrationsystem.service.dto.FacultyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    //create faculty
    @PostMapping("")
    public ResponseEntity<FacultyDto> createFaculty(@RequestBody FacultyDto facultyDto) {
        return ResponseEntity.ok().body(facultyService.addFaculty(facultyDto));
    }

    // get faculty by id
    @GetMapping("/{id}")
    public ResponseEntity<FacultyDto> getFacultyById(@RequestParam long id) {
        return ResponseEntity.ok().body(facultyService.getFacultyById(id));
    }


    //get all faculties

    @GetMapping("")
    public ResponseEntity<List<FacultyDto>> getAllFaculties() {
        return ResponseEntity.ok().body(facultyService.getAllFaculties());
    }

    //update faculty

    @PutMapping("")
    public ResponseEntity<FacultyDto> updateFaculty(@RequestBody FacultyDto facultyDto) {
        return ResponseEntity.ok().body(facultyService.updateFaculty(facultyDto));
    }


    //delete faculty
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(@RequestParam int id) {
        return ResponseEntity.ok().body(facultyService.deleteFaculty(id));
    }


}
