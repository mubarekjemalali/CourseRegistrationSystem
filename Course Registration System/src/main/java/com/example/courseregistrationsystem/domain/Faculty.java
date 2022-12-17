package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
    @OneToOne
    private Address address;

}
