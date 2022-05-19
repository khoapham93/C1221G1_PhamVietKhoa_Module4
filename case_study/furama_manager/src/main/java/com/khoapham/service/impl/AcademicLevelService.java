package com.khoapham.service.impl;

import models.AcademicLevel;
import repository.IAcademicLevelRepository;
import repository.impl.AcademicLevelRepositoryImpl;
import service.IAcademicLevelService;

import java.util.List;

public class AcademicLevelService implements IAcademicLevelService {
  private IAcademicLevelRepository iAcademicLevelRepository = new AcademicLevelRepositoryImpl();
    @Override
    public List<AcademicLevel> getList() {
        return iAcademicLevelRepository.getList();
    }
}
