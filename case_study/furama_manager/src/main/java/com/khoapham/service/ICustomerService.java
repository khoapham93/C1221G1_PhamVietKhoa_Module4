package com.khoapham.service;

import com.khoapham.dto.CustomerDto;
import com.khoapham.exception.ObjectNotFound;
import com.khoapham.models.customer.Customer;
import com.khoapham.dto.CustomerHaveBooking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

public interface ICustomerService extends ICRUDService<Customer> {
    Page<Customer> findAll(String name, String phone, Integer customerType, Pageable pageable);

    Customer findById(Integer id) throws ObjectNotFound;

    void checkExists(CustomerDto customerDto, BindingResult bindingResult);

    Page<CustomerHaveBooking> findAllCustomerHaveBooking(Pageable pageable);
}
