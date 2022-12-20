package com.example.courseregistrationsystem.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@RequiredArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String courseName;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Course> preRequisites;


}
