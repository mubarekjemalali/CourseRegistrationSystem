package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.service.dto.FacultyDto;

import java.util.List;

public interface FacultyService {
    FacultyDto addFaculty(FacultyDto facultyDto);

    FacultyDto getFacultyById(long id);

    List<FacultyDto> getAllFaculties();

    FacultyDto updateFaculty(FacultyDto facultyDto);

    String deleteFaculty(int id);
}
