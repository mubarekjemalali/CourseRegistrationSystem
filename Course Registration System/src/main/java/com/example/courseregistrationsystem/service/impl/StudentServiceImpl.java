package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.domain.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.repo.StudentRepository;
import com.example.courseregistrationsystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public RegistrationEventDto getRegistrationEvent() {

        // TODO: we need to pass the student id

        Student student = studentRepository.findById(1l);
        return modelMapper.map(student.getRegistrationGroup().getRegistrationEvent(), RegistrationEventDto.class);

    }
}
