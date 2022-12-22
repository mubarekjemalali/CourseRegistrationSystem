package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.Registration;
import com.example.courseregistrationsystem.domain.RegistrationRequest;
import com.example.courseregistrationsystem.service.dto.*;

import java.util.List;

public interface StudentService {
    RegistrationEventWOStudentList getRegistrationEvent(long id);

    List<StudentDto> getAllStudents();

    StudentDto addStudent(StudentDto studentDto);

    StudentDto getStudentById(long id);

    StudentDto updateStudent(long id, StudentDto studentDto);

    String deleteStudent(long id);

    String addRegistrationRequests(List<RegistrationRequestDto> registrationRequestsDtos, long id);

    RegistrationRequestDto addRegistrationRequest(RegistrationRequestDto registrationRequestDto, CourseOfferingDto courseOfferingDto, long studentId);

    List<RegistrationRequestDto> getRegistrationRequests(long id);

    List<RegistrationDto> getRegistrations(long id);

//    StudentDto addStudent(StudentDto studentDto);
}

