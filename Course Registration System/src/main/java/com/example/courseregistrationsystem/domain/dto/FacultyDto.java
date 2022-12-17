package com.example.courseregistrationsystem.domain.dto;

import lombok.Data;

import javax.persistence.*;


@Data
public class FacultyDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String title;

    private AddressDto addressDto;

}
