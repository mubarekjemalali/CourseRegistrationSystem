package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Course> courses;
    private int capacity;

    @ManyToOne
    @JoinColumn
    private Faculty faculty;
    @ManyToOne
    private AcademicBlock academicBlock;
    @ManyToOne
    @JoinColumn
    private Course course;
    @OneToMany
    private List<Registration> registrations;
    @OneToMany
    private List<RegistrationRequest> registrationRequests;
}
