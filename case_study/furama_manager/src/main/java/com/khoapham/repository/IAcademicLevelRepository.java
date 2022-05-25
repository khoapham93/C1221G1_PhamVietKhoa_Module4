package com.khoapham.repository;

import com.khoapham.models.employee.AcademicLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAcademicLevelRepository extends JpaRepository<AcademicLevel,Integer> {
}
