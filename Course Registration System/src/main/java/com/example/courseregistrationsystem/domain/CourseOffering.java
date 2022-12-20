package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
