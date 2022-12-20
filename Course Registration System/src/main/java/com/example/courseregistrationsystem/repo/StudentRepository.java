package com.example.courseregistrationsystem.repo;

import com.example.courseregistrationsystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findById(long id);


    Student findByFirstName(String mubarek);

    // find student by registration group then registration event


//    List<Student> findAllByRegistrationGroup_RegistrationEvents_Id(long eventId);


}
