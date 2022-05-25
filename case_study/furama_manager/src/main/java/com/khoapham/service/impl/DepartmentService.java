package com.khoapham.service.impl;

import com.khoapham.models.employee.Department;
import com.khoapham.repository.IDepartmentRepository;
import com.khoapham.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository iDepartmentRepository;

    @Override
    public List<Department> findAll() {
        return iDepartmentRepository.findAll();
    }
}
