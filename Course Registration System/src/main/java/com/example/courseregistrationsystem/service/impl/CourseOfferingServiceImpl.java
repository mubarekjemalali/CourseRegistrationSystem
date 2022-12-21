package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.AcademicBlock;
import com.example.courseregistrationsystem.domain.Course;
import com.example.courseregistrationsystem.domain.CourseOffering;
import com.example.courseregistrationsystem.domain.Faculty;
import com.example.courseregistrationsystem.repo.CourseOfferingRepository;
import com.example.courseregistrationsystem.service.AcademicBlockService;
import com.example.courseregistrationsystem.service.CourseOfferingService;
import com.example.courseregistrationsystem.service.CourseService;
import com.example.courseregistrationsystem.service.FacultyService;
import com.example.courseregistrationsystem.service.dto.AcademicBlockDto;
import com.example.courseregistrationsystem.service.dto.CourseDto;
import com.example.courseregistrationsystem.service.dto.CourseOfferingDto;
import com.example.courseregistrationsystem.service.dto.FacultyDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseOfferingServiceImpl implements CourseOfferingService {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private AcademicBlockService academicBlockService;

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CourseOfferingDto createCourseOffering(CourseOfferingDto courseOfferingDto, long courseId, long facultyId, long academicBlockId) {
        CourseDto courseDto = courseService.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        FacultyDto facultyDto = facultyService.findById(facultyId).orElseThrow(() -> new RuntimeException("Faculty not found"));
        AcademicBlockDto academicBlockDto = academicBlockService.findById(academicBlockId).orElseThrow(() -> new RuntimeException("Academic block not found"));

        CourseOffering courseOffering = mapper.map(courseOfferingDto, CourseOffering.class);
        courseOffering.setCourse(mapper.map(courseDto, Course.class));
        courseOffering.setFaculty(mapper.map(facultyDto, Faculty.class));
        courseOffering.setAcademicBlock(mapper.map(academicBlockDto, AcademicBlock.class));

        return mapper.map(courseOfferingRepository.save(courseOffering), CourseOfferingDto.class);
    }
}
