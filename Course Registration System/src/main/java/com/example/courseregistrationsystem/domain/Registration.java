package com.example.courseregistrationsystem.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // a registration has only one course offering
    @OneToOne
    private CourseOffering courseOffering;

//    public Registration() {
//
//    }

}
