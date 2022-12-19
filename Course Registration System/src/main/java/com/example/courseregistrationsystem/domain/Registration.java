package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private CourseOffering courseOffering;


}
