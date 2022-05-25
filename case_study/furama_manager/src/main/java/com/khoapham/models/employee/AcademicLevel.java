package com.khoapham.models.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AcademicLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String academic;

    @OneToMany(mappedBy = "academicLevel")
    private Set<Employee> employeeSet;

    public AcademicLevel(Integer id, String academic, Set<Employee> employeeSet) {
        this.id = id;
        this.academic = academic;
        this.employeeSet = employeeSet;
    }

    public AcademicLevel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcademic() {
        return academic;
    }

    public void setAcademic(String level) {
        this.academic = level;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
