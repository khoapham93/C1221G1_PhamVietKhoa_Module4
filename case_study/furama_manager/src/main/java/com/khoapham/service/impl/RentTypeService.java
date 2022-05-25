package com.khoapham.service.impl;

import com.khoapham.models.facility.RentType;
import com.khoapham.repository.IRentTypeRepository;
import com.khoapham.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return this.iRentTypeRepository.findAll();
    }
}
