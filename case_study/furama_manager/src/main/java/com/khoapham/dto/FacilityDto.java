package com.khoapham.dto;

import com.khoapham.models.facility.FacilityType;
import com.khoapham.models.facility.RentType;
import com.khoapham.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

public class FacilityDto implements Validator {
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
    @NotNull(message = "{object.empty} facilityType")
    private FacilityType facilityType;
    @NotNull(message = "{object.empty} rentType")
    private RentType rentType;
    private String freeServiceInclude;

    public FacilityDto(Integer id,
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

    public FacilityDto(String code,
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

    public FacilityDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;

        String code = facilityDto.getCode();
        Validation.checkFacilityCode("code", code, errors);

        String name = facilityDto.getName();
        Validation.checkFacilityName("name", name, errors);

        Double floorSquare = facilityDto.getFloorSquare();
        Validation.checkPositiveDouble("floorSquare", floorSquare, errors);

        Double rentalFee = facilityDto.getRentalFee();
        Validation.checkPositiveDouble("rentalFee", rentalFee, errors);

        Integer maximumPeople = facilityDto.getMaximumPeople();
        Validation.checkMaximumPeople("maximumPeople", maximumPeople, errors);

        if (facilityDto.getFacilityType() != null) {
            Integer facilityTypeId = facilityDto.getFacilityType().getId();
            if (facilityTypeId < 2) {
                Double poolSquare = facilityDto.getPoolSquare();
                Validation.checkPositiveDouble("poolSquare", poolSquare, errors);
            }
            if (facilityTypeId < 3) {
                String roomStandard = facilityDto.getRoomStandard();
                Validation.checkEmpty("roomStandard", roomStandard, errors);

                String description = facilityDto.getDescription();
                Validation.checkEmpty("description", description, errors);

                Integer numberFloor = facilityDto.getNumberFloor();
                Validation.checkNumberFloor("numberFloor", numberFloor, errors);
            }
            if (facilityTypeId == 3) {
                String freeServiceInclude = facilityDto.getFreeServiceInclude();
                Validation.checkEmpty("freeServiceInclude", freeServiceInclude, errors);
            }
        }

    }
}
