package com.example.courseregistrationsystem.repo;

import com.example.courseregistrationsystem.domain.RegistrationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationGroupRepository extends JpaRepository<RegistrationGroup, Long> {

}
