package com.example.courseregistrationsystem.service.dto;

import com.example.courseregistrationsystem.domain.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseOfferingDto {

    private Long id;
    private String code;

    private FacultyDto facultyDto;

    private AcademicBlockDto academicBlock;
    private CourseDto course;


}
