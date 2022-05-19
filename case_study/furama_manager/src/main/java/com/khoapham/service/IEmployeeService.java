package com.khoapham.service;

import com.khoapham.models.Employee;
import dto.EmployeeDTO;
import models.Employee;

import java.awt.print.Pageable;
import java.util.List;

public interface IEmployeeService extends ICRUDService<Employee> {
    Pageable<EmployeeDTO> getList();

    Employee findById(Integer id);

    List<EmployeeDTO> search(String fieldSearch1, String fieldSearch2, String fieldSearch3, String searchKey1, String searchKey2, String searchKey3);
}
