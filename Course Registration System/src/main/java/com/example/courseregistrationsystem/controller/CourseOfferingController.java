package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.service.CourseOfferingService;
import com.example.courseregistrationsystem.service.dto.CourseOfferingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course-offering")
public class CourseOfferingController {
    @Autowired
    private CourseOfferingService courseOfferingService;

    // create course offering
    @PostMapping("/{courseId}/{facultyId}/{academicBlockId}")
    public ResponseEntity<CourseOfferingDto> createCourseOffering(@RequestBody CourseOfferingDto courseOfferingDto,
                                                                 @PathVariable long courseId,
                                                                 @PathVariable long facultyId,
                                                                 @PathVariable long academicBlockId) {
        return ResponseEntity.ok(courseOfferingService.createCourseOffering(courseOfferingDto, courseId, facultyId, academicBlockId));
    }


}
