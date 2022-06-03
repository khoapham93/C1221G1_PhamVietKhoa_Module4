package com.khoapham.service;

import com.khoapham.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface IOrderService {
    Page<Orders> findAll(LocalDate fromDate, LocalDate toDate, Pageable pageable);

    Page<Orders> findAllAndOrderTop(LocalDate fromDateVal, LocalDate toDateVal, Pageable pageable);

    Orders findById(int id);

    void save(Orders orders);
}
