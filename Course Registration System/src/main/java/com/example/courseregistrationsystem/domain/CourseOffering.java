package com.example.courseregistrationsystem.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    private Faculty faculty;

    @ManyToOne
    @JoinColumn()
    private AcademicBlock academicBlock;

    @OneToOne
    private Course course;

    // has list of students who is registered for this course
//    @OneToMany
//    private List<Registration> registrations;

    // has list of students who requested to register for this course
//    @OneToMany
//    private List<RegistrationRequest> registrationRequests;

    // to remove the bidirectional relationship
    // we can get the list of students who requested to register for this course
    // from student.registrationRequests by passing the courseOfferingId


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseOffering that = (CourseOffering) o;
        return id.equals(that.id) && code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }
}
