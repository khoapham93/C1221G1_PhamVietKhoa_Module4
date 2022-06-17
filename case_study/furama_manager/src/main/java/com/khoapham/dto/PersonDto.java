package com.khoapham.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.khoapham.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public abstract class PersonDto implements Validator {
    private Integer id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate birthday;
    private String idCard;
    private String phone;
    private String email;
    private String address;

    public PersonDto(Integer id, String name, LocalDate birthday, String idCard, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public PersonDto(String name, LocalDate birthday, String idCard, String phone, String email, String address) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public PersonDto() {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        PersonDto personDto = (PersonDto) target;

        String name = personDto.getName();
        Validation.checkVietnameseName("name", name, errors);

        LocalDate birthday = personDto.getBirthday();
        Validation.checkBirthday("birthday", birthday, errors);

        String idCard = personDto.getIdCard();
        Validation.checkIdCard("idCard", idCard, errors);

        String phone = personDto.getPhone();
        Validation.checkPhone("phone", phone, errors);

        String email = personDto.getEmail();
        Validation.checkEmail("email", email, errors);

        String address = personDto.getAddress();
        Validation.checkEmpty("address", address, errors);
    }

}
