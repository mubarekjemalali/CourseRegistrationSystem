package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne
    private Address mailingAddress;
    @OneToOne
    private Address HomeAddress;
    @OneToMany
    private List<RegistrationRequest> registrationRequests;

    @OneToMany
    private List<Registration> registrations;

    @ManyToOne
    private RegistrationGroup registrationGroup;

}
