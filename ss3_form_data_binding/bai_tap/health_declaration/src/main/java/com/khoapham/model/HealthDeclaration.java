package com.khoapham.model;

import java.time.LocalDate;

public class HealthDeclaration {
    private String name;
    private String birthday;
    private String gender;
    private String national;
    private String idCard;
    private String vehicle;
    private String licensePlate;
    private Integer numberOfSeat;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String cityArrived;

    public HealthDeclaration(String name, String birthday, String gender, String national, String idCard, String vehicle, String licensePlate, Integer numberOfSeat, LocalDate dateStart, LocalDate dateEnd, String cityArrived) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.national = national;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.licensePlate = licensePlate;
        this.numberOfSeat = numberOfSeat;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.cityArrived = cityArrived;
    }

    public HealthDeclaration() {
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(Integer numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public String getCityArrived() {
        return cityArrived;
    }

    public void setCityArrived(String cityArrived) {
        this.cityArrived = cityArrived;
    }

    @Override
    public String toString() {
        return "HealthDeclaration{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", dateStart=" + dateStart +
                ", cityArrived='" + cityArrived + '\'' +
                '}';
    }
}
