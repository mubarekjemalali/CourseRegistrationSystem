package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.AcademicBlock;
import com.example.courseregistrationsystem.repo.AcademicBlockRepository;
import com.example.courseregistrationsystem.service.AcademicBlockService;
import com.example.courseregistrationsystem.service.dto.AcademicBlockDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcademicBlockServiceImpl implements AcademicBlockService {
    @Autowired
    private AcademicBlockRepository academicBlockRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<AcademicBlockDto> findById(long academicBlockId) {
        AcademicBlock academicBlock = academicBlockRepository.findById(academicBlockId).orElse(null);
        return Optional.ofNullable(mapper.map(academicBlock, AcademicBlockDto.class));
    }
}
