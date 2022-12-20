package com.example.courseregistrationsystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address mailingAddress;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address HomeAddress;

    @OneToMany(cascade = {CascadeType.ALL})

    private List<RegistrationRequest> registrationRequests;

    @OneToMany(cascade = {CascadeType.ALL})
    @JsonBackReference
    private List<Registration> registrations;

    @ManyToOne
//    @JsonManagedReference
    private RegistrationGroup registrationGroup;

}
