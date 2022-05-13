package com.khoapham.service.impl;

import com.khoapham.model.Manufacturer;
import com.khoapham.repository.IManufacturerRepository;
import com.khoapham.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService implements IManufacturerService {
    @Autowired
    private IManufacturerRepository iManufacturerRepository;

    @Override
    public List<Manufacturer> findAll() {
        return this.iManufacturerRepository.findAll();
    }
}
