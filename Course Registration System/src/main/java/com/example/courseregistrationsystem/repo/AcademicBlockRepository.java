package com.example.courseregistrationsystem.repo;

import com.example.courseregistrationsystem.domain.AcademicBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicBlockRepository extends JpaRepository<AcademicBlock, Long> {
}
