package com.khoapham.repository;

import com.khoapham.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findByNameContainingAndPhoneContaining(String name, String phone, Pageable pageable);

    Page<Customer> findAllByNameContainingAndPhoneContainingAndCustomerType_Id(String name, String phone, Integer customerType, Pageable pageable);

    Customer findFirstByEmail(String email);

    Customer findFirstByPhone(String phone);

    Customer findFirstByIdCard(String idCard);

    Customer findFirstByCustomerCode(String customerCode);
}
