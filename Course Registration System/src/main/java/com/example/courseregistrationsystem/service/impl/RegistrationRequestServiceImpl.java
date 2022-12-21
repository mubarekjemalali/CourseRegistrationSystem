package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.RegistrationRequest;
import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.repo.RegistrationRequestRepository;
import com.example.courseregistrationsystem.service.RegistrationRequestService;
import com.example.courseregistrationsystem.service.StudentService;
import com.example.courseregistrationsystem.service.dto.RegistrationRequestDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

//    @Autowired
//    private StudentService studentService;

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public RegistrationRequestDto createRegistrationRequest(RegistrationRequest registrationRequest) {
        return mapper.map(registrationRequestRepository.save(registrationRequest), RegistrationRequestDto.class);
    }

//    @Override
//    public void save(RegistrationRequestDto registrationRequestDto) {
//        // get student by id
//        // update the registration request and save the student
//        StudentDto studentDto = studentService.getStudentById(1);
//        studentDto.getRegistrationRequests().add(registrationRequestDto);
//
//        registrationRequestRepository.save(mapper.map(registrationRequestDto, RegistrationRequest.class));
//    }

}
