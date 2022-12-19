package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.Registration;
import com.example.courseregistrationsystem.domain.dto.RegistrationDto;
import com.example.courseregistrationsystem.repo.RegistrationRepository;
import com.example.courseregistrationsystem.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<RegistrationDto> findAllByStudent_Id(long studentId) {
        return registrationRepository.findAllByStudent_Id(studentId)
                .stream()
                .map(registration -> mapper.map(registration, RegistrationDto.class))
                .collect(Collectors.toList());
    }

}
