package com.example.courseregistrationsystem.domain.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto mailingAddressDto;
    private AddressDto homeAddressDto;
    private List<RegistrationRequestDto> registrationRequestDtos;
    private List<RegistrationDto> registrationDtos;

}
