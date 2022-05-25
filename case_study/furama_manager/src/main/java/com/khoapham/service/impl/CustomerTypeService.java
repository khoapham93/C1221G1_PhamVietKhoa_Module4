package com.khoapham.service.impl;

import com.khoapham.models.customer.CustomerType;
import com.khoapham.repository.ICustomerTypeRepository;
import com.khoapham.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.iCustomerTypeRepository.findAll();
    }
}
