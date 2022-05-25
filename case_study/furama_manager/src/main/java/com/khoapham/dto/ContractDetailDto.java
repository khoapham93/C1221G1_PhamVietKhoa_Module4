package com.khoapham.dto;

import com.khoapham.models.contract.Contract;
import com.khoapham.models.contract.ServiceInclude;
import com.khoapham.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

public class ContractDetailDto implements Validator {
    private Integer id;
    @NotNull(message = "{object.empty} contract")
    private Contract contract;
    @NotNull(message = "{object.empty} service Include")
    private ServiceInclude serviceInclude;
    private Integer quantity;

    public ContractDetailDto(Integer id, Contract contract, ServiceInclude serviceInclude, Integer quantity) {
        this.id = id;
        this.contract = contract;
        this.serviceInclude = serviceInclude;
        this.quantity = quantity;
    }

    public ContractDetailDto(Contract contract, ServiceInclude serviceInclude, Integer quantity) {

        this.contract = contract;
        this.serviceInclude = serviceInclude;
        this.quantity = quantity;
    }

    public ContractDetailDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ServiceInclude getServiceInclude() {
        return serviceInclude;
    }

    public void setServiceInclude(ServiceInclude serviceInclude) {
        this.serviceInclude = serviceInclude;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDto contractDetailDto = (ContractDetailDto) target;
        Integer quantity = contractDetailDto.getQuantity();
        Validation.checkPositiveInteger("quantity", quantity, errors);
    }
}
