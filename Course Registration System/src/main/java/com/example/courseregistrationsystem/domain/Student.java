package com.example.courseregistrationsystem.domain;

import com.example.courseregistrationsystem.service.dto.AddressDto;
import com.example.courseregistrationsystem.service.dto.RegistrationDto;
import com.example.courseregistrationsystem.service.dto.RegistrationGroupDto;
import com.example.courseregistrationsystem.service.dto.RegistrationRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Address homeAddress;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<RegistrationRequest> registrationRequests;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Registration> registrations;


//
//    @ManyToOne
//    private RegistrationGroup registrationGroup;

}
