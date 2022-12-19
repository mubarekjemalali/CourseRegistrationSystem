package com.example.courseregistrationsystem.domain;

import lombok.Data;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

   @OneToOne(cascade = CascadeType.PERSIST, optional = true)
    private Address mailingAddress;

  @OneToOne(cascade = CascadeType.PERSIST, optional = true)

  private Address HomeAddress;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<RegistrationRequest> registrationRequests;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Registration> registrations;

    @ManyToOne
    private RegistrationGroup registrationGroup;

}
