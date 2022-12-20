package com.example.courseregistrationsystem.domain;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
@RequiredArgsConstructor

public class RegistrationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany( cascade = CascadeType.PERSIST)
    private List<RegistrationGroup> registrationGroups;

}
