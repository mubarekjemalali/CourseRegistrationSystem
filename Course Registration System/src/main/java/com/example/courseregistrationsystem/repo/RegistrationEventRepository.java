package com.example.courseregistrationsystem.repo;

import com.example.courseregistrationsystem.domain.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent, Long> {

//    @Query("SELECT re FROM RegistrationEvent re JOIN re.registrationGroups rg JOIN rg.students s WHERE s.id = ?1 ORDER BY re.startDate DESC")
//    public RegistrationEvent findAllByStudentId(Long studentId);

}
