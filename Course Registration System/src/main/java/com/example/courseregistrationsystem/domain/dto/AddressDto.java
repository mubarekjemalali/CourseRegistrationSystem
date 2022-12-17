package com.example.courseregistrationsystem.domain.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
public class AddressDto {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

}
