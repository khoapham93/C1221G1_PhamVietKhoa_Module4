package com.khoapham.repository;

import com.khoapham.models.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {

}
