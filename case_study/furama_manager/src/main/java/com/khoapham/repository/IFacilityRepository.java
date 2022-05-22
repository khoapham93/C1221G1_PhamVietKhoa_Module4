package com.khoapham.repository;

import com.khoapham.models.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findAllByNameContainingAndRoomStandardContaining(String name, String roomStandard, Pageable pageable);

    Page<Facility> findAllByNameContainingAndRoomStandardContainingAndFacilityType_Id(String name, String roomStandard, Integer facilityType, Pageable pageable);

}
