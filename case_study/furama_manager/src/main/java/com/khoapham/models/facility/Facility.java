package com.khoapham.models.facility;

import com.khoapham.models.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private Double floorSquare;
    private Double rentalFee;
    private Integer maximumPeople;
    private String roomStandard;
    private String description;
    private Double poolSquare;
    private Integer numberFloor;
    private String freeServiceInclude;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "id")
    private FacilityType facilityType;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentType;

    @OneToMany(mappedBy = "facility")
    private Set<Contract> contractSet;

    public Facility(Integer id,
                    String code,
                    String name,
                    Double floorSquare,
                    Double rentalFee,
                    Integer maximumPeople,
                    String roomStandard,
                    String description,
                    Double poolSquare,
                    Integer numberFloor,
                    FacilityType facilityType,
                    RentType rentType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.floorSquare = floorSquare;
        this.rentalFee = rentalFee;
        this.maximumPeople = maximumPeople;
        this.roomStandard = roomStandard;
        this.description = description;
        this.poolSquare = poolSquare;
        this.numberFloor = numberFloor;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Facility(String code,
                    String name,
                    Double floorSquare,
                    Double rentalFee,
                    Integer maximumPeople,
                    String roomStandard,
                    String description,
                    Double poolSquare,
                    Integer numberFloor,
                    FacilityType facilityType,
                    RentType rentType) {
        this.code = code;
        this.name = name;
        this.floorSquare = floorSquare;
        this.rentalFee = rentalFee;
        this.maximumPeople = maximumPeople;
        this.roomStandard = roomStandard;
        this.description = description;
        this.poolSquare = poolSquare;
        this.numberFloor = numberFloor;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Facility() {
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getFreeServiceInclude() {
        return freeServiceInclude;
    }

    public void setFreeServiceInclude(String freeServiceInclude) {
        this.freeServiceInclude = freeServiceInclude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFloorSquare() {
        return floorSquare;
    }

    public void setFloorSquare(Double floorSquare) {
        this.floorSquare = floorSquare;
    }

    public Double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(Double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public Integer getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(Integer maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolSquare() {
        return poolSquare;
    }

    public void setPoolSquare(Double poolSquare) {
        this.poolSquare = poolSquare;
    }

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }
}
