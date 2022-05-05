package com.khoapham.model;

import java.time.LocalDate;

public class HealthDeclaration {
    private String name;
    private String birthday;
    private String gender;
    private String idCard;
    private String vehicle;
    private String licensePlate;
    private LocalDate dateStart;
    private String cityArrived;

    public HealthDeclaration(String name, String birthday, String gender, String idCard, String vehicle, String licensePlate, LocalDate dateStart, String cityArrived) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.licensePlate = licensePlate;
        this.dateStart = dateStart;
        this.cityArrived = cityArrived;
    }

    public HealthDeclaration() {
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
