package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.*;
import com.example.courseregistrationsystem.repo.CourseOfferingRepository;
import com.example.courseregistrationsystem.service.RegistrationEventService;
import com.example.courseregistrationsystem.service.RegistrationRequestService;
import com.example.courseregistrationsystem.service.dto.*;
import com.example.courseregistrationsystem.repo.StudentRepository;
import com.example.courseregistrationsystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Temporal;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RegistrationRequestService registrationRequestService;
    @Autowired
    private RegistrationEventService registrationEventService;

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;
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
                .map(student -> mapper.map(student, StudentDto.class)).collect(Collectors.toList());

    }

    // get student by id
    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return mapper.map(student, StudentDto.class);
    }

    // add student
    @Override
    public StudentDto addStudent(StudentDto studentDto) {

        Student student = studentRepository.save(mapper.map(studentDto, Student.class));
        return  mapper.map(student, StudentDto.class);
    }


    @Override
    public StudentDto updateStudent(long id, StudentDto studentDto) {
        Student student = studentRepository.save(mapper.map(studentDto, Student.class));
        return mapper.map(student, StudentDto.class);
    }

    @Override
    public String deleteStudent(long id) {
        studentRepository.deleteById(id);
//        studentRepository.deleteById(id);
        return "Student with id: " + id + " has been deleted";
    }

    @Override
    public String addRegistrationRequests(List<RegistrationRequestDto> registrationRequestsDtos, long id) {
        System.out.println("printing id    " + id);
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        System.out.println(student.getFirstName());
        // group the registration requests by course offering then academic block


        // get the course offering id from the user input(registration request)
        //get the course offering from the db using the id
        // set the course offering of the registration request to the course offering from the db
        registrationRequestsDtos.stream()
                .forEach(registrationRequestDto -> {

                    registrationRequestDto.setCourseOffering(mapper.map(courseOfferingRepository
                            .findById(registrationRequestDto.getCourseOffering().getId())
                            .orElseThrow(() -> new RuntimeException("Course Offering not found")), CourseOfferingDto.class));

                });



        Map<AcademicBlockDto, List<RegistrationRequestDto>> registrationRequestDtosPerBlock = registrationRequestsDtos.stream()
                .collect(Collectors.groupingBy(registrationRequestsDto -> registrationRequestsDto.getCourseOffering().getAcademicBlock()));





        Set<RegistrationRequestDto> tempRegistrationRequestDtos = new HashSet<>();

        registrationRequestDtosPerBlock.forEach((academicBlockDto, registrationRequestDtos) -> {
            registrationRequestDtos.stream()
                    .forEach(registrationRequestDto -> tempRegistrationRequestDtos.add(registrationRequestDto));
            if(tempRegistrationRequestDtos.size() < registrationRequestDtos.size()) {
                throw new RuntimeException("You can only register for one course per academic block");
            }
        });
        List<RegistrationRequest> registrationRequests = registrationRequestsDtos.stream()
                .map(registrationRequestDto -> mapper.map(registrationRequestDto, RegistrationRequest.class))
                .collect(Collectors.toList());

        student.setRegistrationRequests(registrationRequests);
        studentRepository.save(student);
        return "registration request has been added";
    }

    @Override
    public RegistrationRequestDto addRegistrationRequest(RegistrationRequestDto registrationRequestDto, CourseOfferingDto courseOfferingDto, long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        RegistrationRequest registrationRequest = mapper.map(registrationRequestDto, RegistrationRequest.class);
        registrationRequest.setCourseOffering(mapper.map(courseOfferingDto, CourseOffering.class));
        student.getRegistrationRequests().add(mapper.map(registrationRequestDto, RegistrationRequest.class));
        studentRepository.save(student);
        return registrationRequestService.createRegistrationRequest(registrationRequest);
    }

    @Override
    public List<RegistrationRequestDto> getRegistrationRequests(long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        List<RegistrationRequest> registrationRequests = student.getRegistrationRequests();
        return registrationRequests.stream().map(registrationRequest -> mapper.map(registrationRequest, RegistrationRequestDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RegistrationDto> getRegistrations(long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        List<Registration> registrations = student.getRegistrations();
        return registrations.stream().map(registration -> mapper.map(registration, RegistrationDto.class)).collect(Collectors.toList());
    }

}
