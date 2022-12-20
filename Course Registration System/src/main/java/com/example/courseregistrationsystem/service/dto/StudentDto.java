package com.example.courseregistrationsystem.service.dto;

import com.example.courseregistrationsystem.domain.RegistrationGroup;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto mailingAddress;
    private AddressDto homeAddress;
    private List<RegistrationRequestDto> registrationRequests;
    @JsonManagedReference
    private List<RegistrationDto> registrations;
    @JsonBackReference
    private RegistrationGroupDto registrationGroup;

}
