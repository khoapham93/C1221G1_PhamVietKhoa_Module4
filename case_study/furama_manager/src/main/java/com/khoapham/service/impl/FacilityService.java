package com.khoapham.service.impl;

import com.khoapham.dto.FacilityDto;
import com.khoapham.models.facility.Facility;
import com.khoapham.repository.IFacilityRepository;
import com.khoapham.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAll(String name, String roomStandard, Integer facilityType, Pageable pageable) {
        if (facilityType == -1) {
            return this.iFacilityRepository.findAllByNameContainingAndRoomStandardContainingAndStatus
                    (name, roomStandard, true, pageable);
        } else {
            return this.iFacilityRepository.findAllByNameContainingAndRoomStandardContainingAndFacilityType_IdAndStatus
                    (name, roomStandard, facilityType, true, pageable);
        }
    }

    @Override
    public Facility findById(Integer id) {
        return this.iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void checkExists(FacilityDto facilityDto, BindingResult bindingResult) {

    }

    @Override
    public List<Facility> findAll() {
        return this.iFacilityRepository.findAllByStatus(true);
    }

    @Override
    public void save(Facility facility) {
        facility.setStatus(true);
        this.iFacilityRepository.save(facility);
    }

    @Override
    public void remove(Facility facility) {
        facility.setStatus(false);
        this.iFacilityRepository.save(facility);
    }
}
