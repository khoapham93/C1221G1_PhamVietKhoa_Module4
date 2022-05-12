package com.khoapham.validation_register_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto implements Validator {

    private Integer id;

    @NotBlank(message = "first Name {name.empty}")
    @Size(min = 5,max = 45)
    private String firstName;

    @NotBlank(message = "last Name {name.empty}")
    @Size(min = 5,max = 45)
    private String lastName;

    @NotBlank(message = "Phone Number {name.empty}")
    private String phoneNumber;

    @NotBlank(message = "email {name.empty}")
    private String email;

    @NotNull(message = "age {name.empty}")
    @Min(18)
    private Integer age;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, String email, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public UserDto(String firstName, String lastName, String phoneNumber, String email, Integer age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;


        if ("".equals(userDto.getFirstName())) {
            errors.rejectValue("firstName","name.empty");
        }
    }
}
