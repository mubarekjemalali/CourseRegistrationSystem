package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.service.dto.RegistrationGroupDto;
import com.example.courseregistrationsystem.service.dto.StudentDto;

import java.util.List;

public interface RegistrationGroupService {
    RegistrationGroupDto createRegistrationGroup(RegistrationGroupDto registrationGroupDto);

    RegistrationGroupDto getRegistrationGroup(long id);

    String deleteRegistrationGroup(long id);

    void addStudentsToRegistrationGroup(long id, List<StudentDto> studentDtos);
}
