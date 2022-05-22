package com.khoapham.dto;

import com.khoapham.models.AcademicLevel;
import com.khoapham.models.Department;
import com.khoapham.models.Position;
import com.khoapham.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

public class EmployeeDto extends PersonDto {
    private Double salary;

    @NotNull(message = "{object.empty} position")
    private Position position;

    @NotNull(message = "{object.empty} academicLevel")
    private AcademicLevel academicLevel;

    @NotNull(message = "{object.empty} department")
    private Department department;

    public EmployeeDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        super.validate(target, errors);

        EmployeeDto employeeDto = (EmployeeDto) target;

        Double salary = employeeDto.getSalary();
        Validation.checkPositiveDouble("salary", salary, errors);
        
    }
}
