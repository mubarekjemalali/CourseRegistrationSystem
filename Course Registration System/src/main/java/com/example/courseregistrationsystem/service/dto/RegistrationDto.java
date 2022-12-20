package com.example.courseregistrationsystem.service.dto;

import com.example.courseregistrationsystem.domain.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {

    private Long id;

    private CourseOfferingDto courseOffering;



}
