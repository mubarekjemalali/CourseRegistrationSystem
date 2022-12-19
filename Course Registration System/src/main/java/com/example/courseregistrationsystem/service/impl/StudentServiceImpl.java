package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.RegistrationEvent;
import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.service.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.repo.StudentRepository;
import com.example.courseregistrationsystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public RegistrationEventDto getRegistrationEvent() {

        // TODO: we need to pass the student id

        Student student = studentRepository.findById(1l);
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

    }
}
