package com.khoapham.models.contract;

import com.khoapham.models.customer.Customer;
import com.khoapham.models.facility.Facility;
import com.khoapham.models.employee.Employee;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double deposit;
    private Double total;

    @ManyToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne()
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;
    private Boolean status;

    public Contract(Integer id, LocalDate startDate, LocalDate endDate, Double deposit, Double total, Employee employee, Customer customer, Facility facility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.total = total;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public Contract(LocalDate startDate, LocalDate endDate, Double deposit, Double total, Employee employee, Customer customer, Facility facility) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.total = total;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public Contract() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
    public String toString() {
        return "startDate=" + startDate +
                ", endDate=" + endDate +
                ", customer=" + customer.getName() +
                ", facility=" + facility.getName();
    }
}
