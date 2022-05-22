package com.khoapham.service.impl;

import com.khoapham.dto.FacilityDto;
import com.khoapham.models.Facility;
import com.khoapham.repository.IFacilityRepository;
import com.khoapham.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    private static final String NAME_REGEX = "^\\p{L}+[0-9]*( (\\p{L}|[0-9])+)*$";
    private static final String FACILITY_CODE_REGEX = "^DV-\\d{4}$";
    private static final String PHONE_REGEX = "^(090|091|\\(84\\)90|\\(84\\)91)\\d{7}$";
    private static final String IDCARD_REGEX = "^d{9}|d{12}$";
    private static final String EMAIL_REGEX = "^\\w+([\\.-]?\\w+)*@[a-z]+\\.(\\w+)(\\.\\w{2,3})?";
    private static final String POSITIVE_INTEGER_REGEX = "^[+]?\\d+$";

    @Override
    public Page<Facility> findAll(String name, String roomStandard, Integer facilityType, Pageable pageable) {
        if (facilityType == -1) {
            return this.iFacilityRepository.findAllByNameContainingAndRoomStandardContaining(name, roomStandard, pageable);
        } else {
            return this.iFacilityRepository.findAllByNameContainingAndRoomStandardContainingAndFacilityType_Id(name, roomStandard, facilityType, pageable);
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
    public void save(Facility facility) {
        this.iFacilityRepository.save(facility);
    }

    @Override
    public void remove(Integer id) {
        this.iFacilityRepository.deleteById(id);
    }
}
