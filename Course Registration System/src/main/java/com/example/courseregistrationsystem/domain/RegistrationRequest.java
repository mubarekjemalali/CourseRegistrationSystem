package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // we need to prioritize the registration requests
    @OneToMany
    private List<CourseOffering> courseOfferings;

}
