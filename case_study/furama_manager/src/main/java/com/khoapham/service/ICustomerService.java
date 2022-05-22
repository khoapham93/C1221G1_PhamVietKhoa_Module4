package com.khoapham.service;

import com.khoapham.dto.CustomerDto;
import com.khoapham.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

public interface ICustomerService extends ICRUDService<Customer> {
    Page<Customer> findAll(String name, String phone, Integer customerType, Pageable pageable);

    Customer findById(Integer id);

    void checkExists(CustomerDto customerDto, BindingResult bindingResult);
}
