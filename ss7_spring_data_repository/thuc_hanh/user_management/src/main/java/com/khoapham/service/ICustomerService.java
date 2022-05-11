package com.khoapham.service;

import com.khoapham.model.Customer;
import com.khoapham.model.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}