package com.example.courseregistrationsystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@RequiredArgsConstructor
public class RegistrationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String track;
    private String semester;
    private String year;

    @OneToMany(cascade = {CascadeType.PERSIST})
    private List<Student> students;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<AcademicBlock> academicBlocks;

    //TODO: stop the infinite loop
//    @ManyToMany
//    private List<RegistrationEvent> registrationEvents;
}
