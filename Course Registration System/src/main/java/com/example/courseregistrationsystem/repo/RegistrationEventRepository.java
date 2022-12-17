package com.example.courseregistrationsystem.repo;

import com.example.courseregistrationsystem.domain.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent, Long> {

}
