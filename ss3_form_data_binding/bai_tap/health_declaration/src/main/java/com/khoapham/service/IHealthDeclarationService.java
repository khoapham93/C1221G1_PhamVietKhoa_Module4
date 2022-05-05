package com.khoapham.service;

import com.khoapham.model.HealthDeclaration;

import java.util.List;

public interface IHealthDeclarationService {

    HealthDeclaration getHealthDeclaration();

    void save(HealthDeclaration healthDeclaration);
}
