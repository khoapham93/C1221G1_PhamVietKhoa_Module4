package com.khoapham.service.impl;

import models.CustomerType;
import repository.ICustomerTypeRepository;
import repository.impl.CustomerTypeRepositoryImpl;
import service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService {
    private ICustomerTypeRepository iCustomerTypeRepository = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> getList() {
        return iCustomerTypeRepository.getList();
    }

}
