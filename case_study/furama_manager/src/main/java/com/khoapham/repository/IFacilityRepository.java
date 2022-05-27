package com.khoapham.repository;

import com.khoapham.models.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    List<Facility> findAllByStatus(Boolean status);

    Page<Facility> findAllByNameContainingAndRoomStandardContainingAndStatus(String name, String roomStandard, Boolean status, Pageable pageable);

    Page<Facility> findAllByNameContainingAndRoomStandardContainingAndFacilityType_IdAndStatus(String name, String roomStandard, Integer facilityType, Boolean status, Pageable pageable);

}
