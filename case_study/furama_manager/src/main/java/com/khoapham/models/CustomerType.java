package com.khoapham.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Integer id;

    @Column(name = "value")
    private String type;

    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customerSet;

    public CustomerType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
    public CustomerType( String type) {
        this.type = type;
    }

    public CustomerType(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
