package com.example.courseregistrationsystem.repo;

import com.example.courseregistrationsystem.domain.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRequestRepository  extends JpaRepository<RegistrationRequest, Long> {
}
