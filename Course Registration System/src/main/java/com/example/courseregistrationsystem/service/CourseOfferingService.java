package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.service.dto.CourseOfferingDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface CourseOfferingService {
    CourseOfferingDto createCourseOffering(CourseOfferingDto courseOfferingDto, long courseId, long facultyId, long academicBlockId);

    CourseOfferingDto getCourseOffering(long id);
}
