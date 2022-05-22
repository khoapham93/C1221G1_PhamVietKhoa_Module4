package com.khoapham.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rentType;
    @OneToMany(mappedBy = "rentType")
    private Set<Facility> facilitySet;

    public RentType(Integer id, String rentType) {
        this.id = id;
        this.rentType = rentType;
    }

    public RentType() {

    }

    public Set<Facility> getFacilitySet() {
        return facilitySet;
    }

    public void setFacilitySet(Set<Facility> facilitySet) {
        this.facilitySet = facilitySet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
}
