package com.example.courseregistrationsystem.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor

public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String facultyInitials;
    private int capacity;
    private int availableSeats;

    @ManyToOne
    @JoinColumn
    private Faculty faculty;
    @ManyToOne
    private AcademicBlock academicBlock;
    @OneToOne
    private Course course;

    // has list of students who is registered for this course
    @OneToMany
    private List<Registration> registrations;

    // has list of students who requested to register for this course
    @OneToMany
    private List<RegistrationRequest> registrationRequests;
}
