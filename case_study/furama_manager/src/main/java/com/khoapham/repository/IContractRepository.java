package com.khoapham.repository;

import com.khoapham.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    Page<Contract> findAllByStartDateGreaterThanEqualAndEndDateIsLessThanEqualAndStatus(LocalDate startDate, LocalDate endDate, Boolean status, Pageable pageable);

    Page<Contract> findAllByStartDateGreaterThanEqualAndStatus(LocalDate startDate, Boolean status, Pageable pageable);

    Page<Contract> findAllByEndDateIsLessThanEqualAndStatus(LocalDate endDate, Boolean status, Pageable pageable);
}
