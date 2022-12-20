package com.example.courseregistrationsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
@RequiredArgsConstructor
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany
    List<CourseOffering> courseOfferings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicBlock that = (AcademicBlock) o;
        return id.equals(that.id) && code.equals(that.code);
    }

}
