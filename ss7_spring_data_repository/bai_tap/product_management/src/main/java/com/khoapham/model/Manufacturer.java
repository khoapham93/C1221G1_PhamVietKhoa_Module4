package com.khoapham.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "manufacturer")
    private Set<Product> productSet;

    public Manufacturer() {
    }

    public Manufacturer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Manufacturer(String name) {

        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
