package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.service.dto.FacultyDto;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
    FacultyDto addFaculty(FacultyDto facultyDto);

    FacultyDto getFacultyById(long id);

    List<FacultyDto> getAllFaculties();


    void deleteFaculty(long id);

    Optional<FacultyDto> findById(long facultyId);
}
