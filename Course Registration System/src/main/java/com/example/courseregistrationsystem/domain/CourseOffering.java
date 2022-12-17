package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    @OneToOne
    private Faculty faculty;
    @OneToOne
    private AcademicBlock academicBlock;
    @OneToMany
    private List<Course> courses;
    @OneToOne
    private Registration registrations;
    @ManyToOne
    private RegistrationRequest registrationRequests;
}
