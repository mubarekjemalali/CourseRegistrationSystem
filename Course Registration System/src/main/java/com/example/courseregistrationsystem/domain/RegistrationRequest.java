package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // priority number 1 - n, n is the number of courses in the academic block
    private int priorityNumber;
    @ManyToOne
    private CourseOffering courseOffering;


}
