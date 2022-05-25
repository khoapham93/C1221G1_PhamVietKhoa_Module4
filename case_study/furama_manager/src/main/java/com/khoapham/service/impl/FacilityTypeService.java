package com.khoapham.service.impl;

import com.khoapham.models.facility.FacilityType;
import com.khoapham.repository.IFacilityTypeRepository;
import com.khoapham.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return this.iFacilityTypeRepository.findAll();
    }
}
