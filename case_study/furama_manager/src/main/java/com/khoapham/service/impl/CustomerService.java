package com.khoapham.service.impl;

import com.khoapham.dto.CustomerDto;
import com.khoapham.exception.ObjectNotFound;
import com.khoapham.models.customer.Customer;
import com.khoapham.dto.CustomerHaveBooking;
import com.khoapham.repository.ICustomerRepository;
import com.khoapham.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(String name, String phone, Integer customerType, Pageable pageable) {
        if (customerType == -1) {
            return this.iCustomerRepository.findByNameContainingAndPhoneContainingAndStatus(name, phone, true, pageable);
        } else {
            return this.iCustomerRepository.findAllByNameContainingAndPhoneContainingAndCustomerType_IdAndStatus(name, phone, customerType, true, pageable);
        }
    }

    @Override
    public Customer findById(Integer id) throws ObjectNotFound {
        Customer customer = this.iCustomerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ObjectNotFound();
        } else {
            return customer;
        }
    }

    @Override
    public void checkExists(CustomerDto customerDto, BindingResult bindingResult) {
        //email
        Customer existsEmail = this.iCustomerRepository.findFirstByEmail(customerDto.getEmail());
        //idCard
        Customer existsPhone = this.iCustomerRepository.findFirstByPhone(customerDto.getPhone());
        //phone
        Customer existsIdCard = this.iCustomerRepository.findFirstByIdCard(customerDto.getIdCard());
        //code
        Customer existsCustomerCode = this.iCustomerRepository.findFirstByCustomerCode(customerDto.getCustomerCode());

        if (customerDto.getId() == null) {
            //Add new
            if (!"".equals(customerDto.getEmail())) {
                if (existsEmail != null) {
                    bindingResult.rejectValue("email", "email.exists");
                }
            }
            if (!"".equals(customerDto.getPhone())) {
                if (existsPhone != null) {
                    bindingResult.rejectValue("phone", "phone.exists");
                }
            }
            if (!"".equals(customerDto.getIdCard())) {
                if (existsIdCard != null) {
                    bindingResult.rejectValue("idCard", "idCard.exists");
                }
            }
            if (!"".equals(customerDto.getCustomerCode())) {
                if (existsCustomerCode != null) {
                    bindingResult.rejectValue("customerCode", "customerCode.exists");
                }
            }
        } else {
            //update
            if (existsEmail != null) {
                if (!existsEmail.getId().equals(customerDto.getId())) {
                    bindingResult.rejectValue("email", "email.exists");
                }
            }
            if (existsPhone != null) {
                if (!existsPhone.getId().equals(customerDto.getId())) {
                    bindingResult.rejectValue("phone", "phone.exists");
                }
            }
            if (existsIdCard != null) {
                if (!existsIdCard.getId().equals(customerDto.getId())) {
                    bindingResult.rejectValue("idCard", "idCard.exists");
                }
            }
            if (existsCustomerCode != null) {
                if (!existsCustomerCode.getId().equals(customerDto.getId())) {
                    bindingResult.rejectValue("customerCode", "customerCode.exists");
                }
            }
        }
    }

    @Override
    public Page<CustomerHaveBooking> findAllCustomerHaveBooking(Pageable pageable) {
        return this.iCustomerRepository.findAllCustomerHaveBooking(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAllByStatus(true);
    }

    @Override
    public void save(Customer customer) {
        customer.setStatus(true);
        this.iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        customer.setStatus(false);
        this.iCustomerRepository.save(customer);
    }
}
