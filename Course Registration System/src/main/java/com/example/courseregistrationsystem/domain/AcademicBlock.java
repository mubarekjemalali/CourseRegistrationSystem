package com.example.courseregistrationsystem.domain;

import com.example.courseregistrationsystem.service.dto.CourseOfferingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
@RequiredArgsConstructor
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;



}
