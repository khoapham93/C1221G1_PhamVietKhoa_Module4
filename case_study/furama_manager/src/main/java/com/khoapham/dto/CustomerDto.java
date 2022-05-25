package com.khoapham.dto;

import com.khoapham.models.customer.CustomerType;
import com.khoapham.util.Validation;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotNull;

public class CustomerDto extends PersonDto {
    private String customerCode;
    @NotNull(message = "{object.empty} customerType")
    private CustomerType customerType;
    private Integer gender;

    public CustomerDto() {
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        super.validate(target, errors);

        CustomerDto customerDto = (CustomerDto) target;

        String customerCode = customerDto.getCustomerCode();
        Validation.checkCustomerCode("customerCode", customerCode, errors);

        Integer gender = customerDto.getGender();
        Validation.checkGender("gender", gender, errors);

    }
}
