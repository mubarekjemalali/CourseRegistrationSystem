package com.example.courseregistrationsystem.repo;

import com.example.courseregistrationsystem.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    List<Registration> findAllByStudent_Id(long studentId);

}

