package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class RegistrationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Student> students;
    @OneToMany
    private List<AcademicBlock> academicBlocks;
    @ManyToMany
    private List<RegistrationEvent> registrationEvents;
}
