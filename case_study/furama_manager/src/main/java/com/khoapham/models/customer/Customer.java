package com.khoapham.models.customer;

import com.khoapham.models.Person;
import com.khoapham.models.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer extends Person {
    private String customerCode;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;
    @Column(columnDefinition = "BIT")
    private Integer gender;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractSet ;

    public Customer() {
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
