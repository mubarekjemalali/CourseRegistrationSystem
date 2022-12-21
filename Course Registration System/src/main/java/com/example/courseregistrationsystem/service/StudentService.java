package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.RegistrationRequest;
import com.example.courseregistrationsystem.service.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;

import java.util.List;

public interface StudentService {
//    RegistrationEventDto getRegistrationEvent();

    List<StudentDto> getAllStudents();

    StudentDto addStudent(StudentDto studentDto);

    StudentDto getStudentById(long id);

    StudentDto updateStudent(long id, StudentDto studentDto);

    String deleteStudent(long id);

    String addRegistrationRequest(List<RegistrationRequest> registrationRequests, long id);

//    StudentDto addStudent(StudentDto studentDto);
}
