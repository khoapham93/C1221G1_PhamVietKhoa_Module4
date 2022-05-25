package com.khoapham.models.facility;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "facility_type")
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String facilityType;

    @OneToMany(mappedBy = "facilityType")
    private Set<Facility> facilitySet;

    public FacilityType(Integer id, String facilityType) {
        this.id = id;
        this.facilityType = facilityType;
    }

    public FacilityType() {
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

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }
}
