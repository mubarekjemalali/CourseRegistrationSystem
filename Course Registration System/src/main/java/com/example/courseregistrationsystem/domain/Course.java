package com.example.courseregistrationsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String courseName;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Course> preRequisites;


    public Course(String code, String courseName, String description) {
        this.code = code;
        this.courseName = courseName;
        this.description = description;
    }
}
