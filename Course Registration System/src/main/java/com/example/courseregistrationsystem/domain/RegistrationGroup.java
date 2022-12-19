package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class RegistrationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String track;
    private String semester;
    private String year;

    @OneToMany(cascade = {CascadeType.PERSIST})
    private List<Student> students;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<AcademicBlock> academicBlocks;

    //TODO: stop the infinite loop
    @ManyToMany
    private List<RegistrationEvent> registrationEvents;
}
