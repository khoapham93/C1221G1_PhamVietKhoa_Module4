package com.khoapham.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer id;
    @Column(name = "position_name")
    private String position;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employeeSet;

    public Position(Integer id, String position, Set<Employee> employeeSet) {
        this.id = id;
        this.position = position;
        this.employeeSet = employeeSet;
    }

    public Position(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
