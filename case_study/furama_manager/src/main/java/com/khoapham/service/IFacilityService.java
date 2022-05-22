package com.khoapham.service;

import com.khoapham.dto.FacilityDto;

import com.khoapham.models.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

public interface IFacilityService extends ICRUDService<Facility> {
    Page<Facility> findAll(String name, String roomStandard, Integer facilityType, Pageable pageable);

    Facility findById(Integer id);

    void checkExists(FacilityDto facilityDto, BindingResult bindingResult);
}
