package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.RegistrationRequest;
import com.example.courseregistrationsystem.service.dto.RegistrationRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRequestService {

    void save(RegistrationRequestDto registrationRequestDto);

}
