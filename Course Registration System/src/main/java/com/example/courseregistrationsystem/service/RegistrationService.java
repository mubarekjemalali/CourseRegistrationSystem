package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.Registration;

import com.example.courseregistrationsystem.service.dto.RegistrationDto;

import java.util.List;

public interface RegistrationService {

    List<RegistrationDto> findAllByStudent_Id(long studentId);

}
