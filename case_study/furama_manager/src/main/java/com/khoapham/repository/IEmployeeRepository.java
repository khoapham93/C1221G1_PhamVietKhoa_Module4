package com.khoapham.repository;

import com.khoapham.models.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByStatus(Boolean status);

    Page<Employee> findByNameContainingAndPhoneContainingAndStatus(String name, String phone, Boolean status, Pageable pageable);

    Page<Employee> findAllByNameContainingAndPhoneContainingAndDepartment_IdAndStatus(String name, String phone, Integer department, Boolean status, Pageable pageable);

    Employee findFirstByEmail(String email);

    Employee findFirstByPhone(String phone);

    Employee findFirstByIdCard(String idCard);

}
