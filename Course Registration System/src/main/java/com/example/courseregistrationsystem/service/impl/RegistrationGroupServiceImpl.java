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

    @Override
    public RegistrationGroupDto getRegistrationGroup(long id) {
        return mapper.map(registrationGroupRepository.findById(id).get(), RegistrationGroupDto.class);
    }

    @Override
    public String deleteRegistrationGroup(long id) {
        registrationGroupRepository.deleteById(id);
        return "Registration group deleted";
    }

    @Override
    public void addStudentsToRegistrationGroup(long id, List<StudentDto> studentDtos) {
        RegistrationGroup registrationGroup = registrationGroupRepository.findById(id).orElse(null);
        if(registrationGroup != null) {
            registrationGroup.getStudents().addAll(studentDtos.stream().map(studentDto -> mapper.map(studentDto, Student.class)).toList());
            registrationGroupRepository.save(registrationGroup);
        }

    }
}
