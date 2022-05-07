package com.khoapham.service.impl;

import com.khoapham.model.Customer;
import com.khoapham.repository.ICustomerRepository;
import com.khoapham.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.iCustomerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        this.iCustomerRepository.update(id,customer);
    }

    @Override
    public void remove(int id) {
        this.iCustomerRepository.remove(id);
    }
}
