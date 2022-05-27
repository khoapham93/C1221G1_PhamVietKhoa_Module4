package com.khoapham.service;

import com.khoapham.dto.CustomerHaveBooking;
import com.khoapham.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface IContractService extends ICRUDService<Contract> {
    Page<Contract> findAll(LocalDate fromDate, LocalDate toDate, Pageable pageable);

    Contract findById(Integer id);

    Page<CustomerHaveBooking> findAllContractAndDetail(LocalDate fromDate, LocalDate toDate, Pageable pageable);
}
