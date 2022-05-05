package com.khoapham.repository;

import com.khoapham.model.HealthDeclaration;

public interface IHealthDeclarationRepository {

    HealthDeclaration getHealthDeclaration();

    void save(HealthDeclaration healthDeclaration);

}
