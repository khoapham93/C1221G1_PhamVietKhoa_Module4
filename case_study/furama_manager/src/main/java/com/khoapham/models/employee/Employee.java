package com.khoapham.models.employee;

import com.khoapham.models.contract.Contract;
import com.khoapham.models.Person;
import com.khoapham.models.user.AppUser;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee extends Person {
    private Double salary;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "academic_id", referencedColumnName = "id")
    private AcademicLevel academicLevel;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contractSet ;

    @OneToOne
    @JoinColumn(name = "username_id",referencedColumnName = "id")
    private AppUser appUser;

    public Employee() {
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public AcademicLevel getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel) {
        this.academicLevel = academicLevel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
