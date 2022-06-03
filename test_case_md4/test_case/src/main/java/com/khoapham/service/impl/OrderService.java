package com.khoapham.service.impl;

import com.khoapham.model.Orders;
import com.khoapham.repository.IOrderRepository;
import com.khoapham.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public Page<Orders> findAll(LocalDate fromDate, LocalDate toDate, Pageable pageable) {
        String from = "";
        String to = "";
        LocalDate now = LocalDate.now();
        if (fromDate == null && toDate == null) {
            to = now.plusYears(100).toString();
        } else if (fromDate != null && toDate != null) {
            from = fromDate.toString();
            to = toDate.toString();
        } else if (fromDate != null) {
            from = fromDate.toString();
            to = now.plusYears(100).toString();
        } else {
            to = toDate.toString();
        }
        return this.iOrderRepository.findAll(from, to, pageable);
    }

    @Override
    public Page<Orders> findAllAndOrderTop(LocalDate fromDateVal, LocalDate toDateVal, Pageable pageable) {
        String from = "";
        String to = "";
        LocalDate now = LocalDate.now();
        if (fromDateVal == null && toDateVal == null) {
            to = now.plusYears(100).toString();
        } else if (fromDateVal != null && toDateVal != null) {
            from = fromDateVal.toString();
            to = toDateVal.toString();
        } else if (fromDateVal != null) {
            from = fromDateVal.toString();
            to = now.plusYears(100).toString();
        } else {
            to = toDateVal.toString();
        }
        return this.iOrderRepository.findAllOrderTop(from, to, pageable);
    }

    @Override
    public Orders findById(int id) {
        return this.iOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Orders orders) {
        this.iOrderRepository.save(orders);
    }
}
