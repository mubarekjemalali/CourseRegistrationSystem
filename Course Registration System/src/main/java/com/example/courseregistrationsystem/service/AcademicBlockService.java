package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.service.dto.AcademicBlockDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface AcademicBlockService {
    Optional<AcademicBlockDto> findById(long academicBlockId);
}
