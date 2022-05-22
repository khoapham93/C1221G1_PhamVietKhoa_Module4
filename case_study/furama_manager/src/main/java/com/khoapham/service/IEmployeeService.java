package com.khoapham.service;

import com.khoapham.dto.EmployeeDto;
import com.khoapham.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

public interface IEmployeeService extends ICRUDService<Employee> {

    Page<Employee> findAll(String name,String phone, Integer department,Pageable pageable);

    Employee findById(Integer id);

    void checkExists(EmployeeDto employeeDto, BindingResult bindingResult);
}
