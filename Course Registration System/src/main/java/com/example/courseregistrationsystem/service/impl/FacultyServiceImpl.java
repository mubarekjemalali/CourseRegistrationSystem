package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.Faculty;
import com.example.courseregistrationsystem.repo.FacultyRepository;
import com.example.courseregistrationsystem.service.FacultyService;
import com.example.courseregistrationsystem.service.dto.FacultyDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public FacultyDto addFaculty(FacultyDto facultyDto) {
        Faculty faculty = facultyRepository.save(mapper.map(facultyDto, Faculty.class));
        return mapper.map(faculty, FacultyDto.class);
    }

    @Override
    public FacultyDto getFacultyById(long id) {
        return mapper.map(facultyRepository.findById(id).get(), FacultyDto.class);
    }

    @Override
    public List<FacultyDto> getAllFaculties() {
        List<Faculty> faculties = facultyRepository.findAll();
        return faculties.stream().map(faculty -> mapper.map(faculty, FacultyDto.class)).collect(Collectors.toList());

    }

    @Override
    public FacultyDto updateFaculty(FacultyDto facultyDto) {
        return null;
    }

    @Override
    public String deleteFaculty(int id) {
        return null;
    }
}
