package com.khoapham.dto;

import com.khoapham.models.employee.AcademicLevel;
import com.khoapham.models.employee.Department;
import com.khoapham.models.employee.Position;
import com.khoapham.util.Validation;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotNull;

public class EmployeeDto extends PersonDto {
    private String salary;

    @NotNull(message = "{object.empty} position")
    private Position position;

    @NotNull(message = "{object.empty} academicLevel")
    private AcademicLevel academicLevel;

    @NotNull(message = "{object.empty} department")
    private Department department;

    public EmployeeDto() {
    }

    public String getSalary() {
        return this.salary;
    }

    public void setSalary(String salary) {
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

        String salary = employeeDto.getSalary();
        Validation.checkStringSalary("salary", salary, errors);

    }
}
