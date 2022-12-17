package com.example.courseregistrationsystem.domain;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
public class RegistrationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "registrationEvent")
    private List<RegistrationGroup> registrationGroups;

}
