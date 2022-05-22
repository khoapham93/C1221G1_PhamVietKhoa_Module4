package com.khoapham.repository;

import com.khoapham.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findByNameContainingAndPhoneContaining(String name, String phone, Pageable pageable);

    Page<Employee> findAllByNameContainingAndPhoneContainingAndDepartment_Id(String name, String phone, Integer department, Pageable pageable);

    Employee findFirstByEmail(String email);

    Employee findFirstByPhone(String phone);

    Employee findFirstByIdCard(String idCard);

}
