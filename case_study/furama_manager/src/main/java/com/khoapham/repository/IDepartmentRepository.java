package com.khoapham.repository;

import com.khoapham.models.employee.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

}
