package com.khoapham.repository.impl;

import com.khoapham.model.HealthDeclaration;
import com.khoapham.repository.IHealthDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HealthDeclarationRepositoryImpl implements IHealthDeclarationRepository {
    private HealthDeclaration healthDeclaration = new HealthDeclaration();

    @Override
    public HealthDeclaration getHealthDeclaration() {
        return this.healthDeclaration;
    }

    @Override
    public void save(HealthDeclaration healthDeclaration) {
        this.healthDeclaration = healthDeclaration;
    }
}
