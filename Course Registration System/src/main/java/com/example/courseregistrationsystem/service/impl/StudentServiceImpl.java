package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.CourseOffering;
import com.example.courseregistrationsystem.domain.RegistrationRequest;
import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.service.RegistrationEventService;
import com.example.courseregistrationsystem.service.RegistrationRequestService;
import com.example.courseregistrationsystem.service.dto.*;
import com.example.courseregistrationsystem.repo.StudentRepository;
import com.example.courseregistrationsystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RegistrationRequestService registrationRequestService;
    @Autowired
    private RegistrationEventService registrationEventService;
//    @Override
    public RegistrationEventWOStudentList getRegistrationEvent(long id) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        // get all events and get the event the student belongs to
          return registrationEventService.findLatestByStudentId(id);

    }

    // get all students
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return studentRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());

    }

    // get student by id
    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return modelMapper.map(student, StudentDto.class);
    }

    // add student
    @Override
    public StudentDto addStudent(StudentDto studentDto) {

        Student student = studentRepository.save(modelMapper.map(studentDto, Student.class));
        return  modelMapper.map(student, StudentDto.class);
    }


    @Override
    public StudentDto updateStudent(long id, StudentDto studentDto) {
        Student student = studentRepository.save(modelMapper.map(studentDto, Student.class));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public String deleteStudent(long id) {
        studentRepository.deleteById(id);
        return "Student with id: " + id + " has been deleted";
    }

    @Override
    public String addRegistrationRequests(List<RegistrationRequest> registrationRequests, long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setRegistrationRequests(registrationRequests);
        studentRepository.save(student);
        return "registration request has been added";
    }

    @Override
    public RegistrationRequestDto addRegistrationRequest(RegistrationRequestDto registrationRequestDto, CourseOfferingDto courseOfferingDto, long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        RegistrationRequest registrationRequest = modelMapper.map(registrationRequestDto, RegistrationRequest.class);
        registrationRequest.setCourseOffering(modelMapper.map(courseOfferingDto, CourseOffering.class));
        student.getRegistrationRequests().add(modelMapper.map(registrationRequestDto, RegistrationRequest.class));
        studentRepository.save(student);
        return registrationRequestService.createRegistrationRequest(registrationRequest);
    }

    @Override
    public List<RegistrationRequestDto> getRegistrationRequests(long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        List<RegistrationRequest> registrationRequests = student.getRegistrationRequests();
        return registrationRequests.stream().map(registrationRequest -> modelMapper.map(registrationRequest, RegistrationRequestDto.class)).collect(Collectors.toList());
    }

}
