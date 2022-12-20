package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.RegistrationEvent;
import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.service.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.repo.StudentRepository;
import com.example.courseregistrationsystem.service.StudentService;
import com.example.courseregistrationsystem.service.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public RegistrationEventDto getRegistrationEvent() {

        // TODO: we need to pass the student id

//        Student student = studentRepository.findById(1l);
        Student student = studentRepository.findByFirstName("Mubarek");
        System.out.println(student.getFirstName());

        System.out.println(student.getRegistrationGroup().getRegistrationEvents().size());

        // get the registration event from the student and get the registration events
        List<RegistrationEvent> registrationEventList = student.getRegistrationGroup().getRegistrationEvents();

        // each student has two registration events
        // the first for (FPP and MPP) and the second for the rest of the courses
        // if the student is Mpp track then the first registration event is for MPP only

        // get the latest event by comparing the dates
        LocalDate latestDate = LocalDate.now();

        // compare the latest date with the start date of the registration event
        // then return the registration event that is closer to the current date
        // Create a localdate form string
        //LocalDate localDate = LocalDate.parse(registrationEventList.get(0).getEndDate());


        var differenceToFirstEvent = latestDate.compareTo(registrationEventList.get(0).getEndDate());
        var differenceToSecondEvent = latestDate.compareTo(registrationEventList.get(1).getEndDate());

        // compare it to end date of the first event,
//        var differenceToFirstEvent = latestDate.compareTo(LocalDate.parse(registrationEventList.get(0).getEndDate()));
//        var differenceToSecondEvent = latestDate.compareTo(LocalDate.parse(registrationEventList.get(1).getEndDate()));
        // compare the difference between the two events
        var registrationEvent = differenceToFirstEvent > differenceToSecondEvent ? registrationEventList.get(1) : registrationEventList.get(0);

        return modelMapper.map(registrationEvent, RegistrationEventDto.class);
//        return "method is working";

    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
//        students.stream().forEach(student -> System.out.println(student));
        Student student1 = students.get(0);
        StudentDto studentDto = modelMapper.map(student1, StudentDto.class);
        System.out.println(studentDto);
        return studentRepository.findAll().stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());

    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = studentRepository.save(modelMapper.map(studentDto, Student.class));
        return  modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(int id) {
        return modelMapper.map(studentRepository.findById(id), StudentDto.class);
    }

    @Override
    public StudentDto updateStudent(int id, StudentDto studentDto) {
        Student student = studentRepository.save(modelMapper.map(studentDto, Student.class));
        return modelMapper.map(student, StudentDto.class);
    }


}
