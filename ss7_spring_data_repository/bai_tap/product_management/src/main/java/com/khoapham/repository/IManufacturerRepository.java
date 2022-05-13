package com.khoapham.repository;

import com.khoapham.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
