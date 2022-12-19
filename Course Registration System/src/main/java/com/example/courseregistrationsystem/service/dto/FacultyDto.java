package com.example.courseregistrationsystem.service.dto;

import lombok.Data;


@Data
public class FacultyDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String title;

    private AddressDto addressDto;

}
