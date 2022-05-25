package com.khoapham.repository;

import com.khoapham.models.contract.ServiceInclude;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceIncludeRepository extends JpaRepository<ServiceInclude, Integer> {
}
