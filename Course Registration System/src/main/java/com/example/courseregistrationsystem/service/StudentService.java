package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.service.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;

import java.util.List;

public interface StudentService {
//    RegistrationEventDto getRegistrationEvent();

    List<StudentDto> getAllStudents();

    StudentDto addStudent(StudentDto studentDto);

    StudentDto getStudentById(int id);

    StudentDto updateStudent(int id, StudentDto studentDto);

    String deleteStudent(long id);

//    StudentDto addStudent(StudentDto studentDto);
}
