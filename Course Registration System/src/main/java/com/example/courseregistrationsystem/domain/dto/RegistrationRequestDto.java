package com.example.courseregistrationsystem.domain.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class RegistrationRequestDto {

    private Long id;

    private CourseOfferingDto courseOfferingDto;

}
