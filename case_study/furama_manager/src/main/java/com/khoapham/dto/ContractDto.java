package com.khoapham.dto;

import com.khoapham.models.customer.Customer;
import com.khoapham.models.employee.Employee;
import com.khoapham.models.facility.Facility;
import com.khoapham.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ContractDto implements Validator {
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double deposit;

    @NotNull(message = "{object.empty} employee")
    private Employee employee;
    @NotNull(message = "{object.empty} customer")
    private Customer customer;
    @NotNull(message = "{object.empty} service")
    private Facility facility;

    public ContractDto(Integer id, LocalDate startDate, LocalDate endDate, Double deposit, Employee employee, Customer customer, Facility facility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public ContractDto(LocalDate startDate, LocalDate endDate, Double deposit, Employee employee, Customer customer, Facility facility) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public ContractDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;

        LocalDate startDate = contractDto.getStartDate();
        Validation.checkStartDate("startDate", startDate, errors);

        LocalDate endDate = contractDto.getEndDate();
        Validation.checkEndDate("endDate", startDate, endDate, errors);

        Double deposit = contractDto.getDeposit();
        Validation.checkPositiveDouble("deposit", deposit, errors);
    }
}

