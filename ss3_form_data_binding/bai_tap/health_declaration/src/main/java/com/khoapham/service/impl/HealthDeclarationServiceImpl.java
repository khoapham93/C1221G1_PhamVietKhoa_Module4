package com.khoapham.service.impl;

import com.khoapham.model.HealthDeclaration;
import com.khoapham.repository.IHealthDeclarationRepository;
import com.khoapham.service.IHealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthDeclarationServiceImpl implements IHealthDeclarationService {

    @Autowired
    private IHealthDeclarationRepository iHealthDeclarationRepository;

    @Override
    public HealthDeclaration getHealthDeclaration() {
        return this.iHealthDeclarationRepository.getHealthDeclaration();
    }

    @Override
    public void save(HealthDeclaration healthDeclaration) {
        this.iHealthDeclarationRepository.save(healthDeclaration);
    }
}
