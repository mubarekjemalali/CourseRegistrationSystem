package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.RegistrationRequest;
import com.example.courseregistrationsystem.domain.dto.RegistrationRequestDto;
import com.example.courseregistrationsystem.repo.RegistrationRequestRepository;
import com.example.courseregistrationsystem.service.RegistrationRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(RegistrationRequestDto registrationRequestDto) {
        registrationRequestRepository.save(mapper.map(registrationRequestDto, RegistrationRequest.class));
    }

}
