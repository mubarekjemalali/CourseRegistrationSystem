package com.example.courseregistrationsystem.service.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationGroupDto {

    private Long id;
    private String track;
    private String semester;
    private String year;

    private List<StudentDto> student;
    private List<AcademicBlockDto> academicBlocks;

}
