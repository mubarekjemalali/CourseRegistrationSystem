package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.RegistrationGroup;
import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.repo.RegistrationGroupRepository;
import com.example.courseregistrationsystem.service.RegistrationGroupService;
import com.example.courseregistrationsystem.service.dto.RegistrationGroupDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationGroupServiceImpl implements RegistrationGroupService {

    @Autowired
    private RegistrationGroupRepository registrationGroupRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public RegistrationGroupDto createRegistrationGroup(RegistrationGroupDto registrationGroupDto) {
        RegistrationGroup registrationGroup = registrationGroupRepository.save(mapper.map(registrationGroupDto, RegistrationGroup.class));
        return mapper.map(registrationGroup, RegistrationGroupDto.class);
    }

    // get registration group by id
    @Override
    public RegistrationGroupDto getRegistrationGroup(long id) {
        RegistrationGroup registrationGroup = registrationGroupRepository.findById(id).orElseThrow(() -> new RuntimeException("Registration group not found"));
        return mapper.map(registrationGroup, RegistrationGroupDto.class);
    }

    // delete registration group by id
    @Override
    public String deleteRegistrationGroup(long id) {

        registrationGroupRepository.deleteById(id);
        return "Registration group deleted";
    }

    // add list of students to registration group
    @Override
    public void addStudentsToRegistrationGroup(long id, List<StudentDto> studentDtos) {
        // get the registration group
        RegistrationGroup registrationGroup = registrationGroupRepository.findById(id).orElse(null);
        if(registrationGroup != null) {
            List<Student> students = studentDtos.stream().map(studentDto -> mapper.map(studentDto, Student.class)).toList();
            registrationGroup.setStudents(students);
            registrationGroupRepository.save(registrationGroup);
        }
    }
}
