package com.khoapham.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AcademicLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academic_id")
    private Integer id;
    @Column(name = "level_name")
    private String level;

    @OneToMany(mappedBy = "academicLevel")
    private Set<Employee> employeeSet;

    public AcademicLevel(Integer id, String level, Set<Employee> employeeSet) {
        this.id = id;
        this.level = level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
