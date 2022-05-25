package com.khoapham.service.impl;

import com.khoapham.models.employee.AcademicLevel;
import com.khoapham.repository.IAcademicLevelRepository;
import com.khoapham.service.IAcademicLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicLevelService implements IAcademicLevelService {
    @Autowired
    private IAcademicLevelRepository iAcademicLevelRepository;

    @Override
    public List<AcademicLevel> findAll() {
        return iAcademicLevelRepository.findAll();
    }
}
