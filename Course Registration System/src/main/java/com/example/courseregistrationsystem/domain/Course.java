package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
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
