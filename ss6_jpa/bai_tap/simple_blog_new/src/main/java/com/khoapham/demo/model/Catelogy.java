package com.khoapham.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "catelogy")
public class Catelogy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "catelogy")
    private Set<Blog> blogSet;

    public Catelogy(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Catelogy( String name) {

        this.name = name;
    }
    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }

    public Catelogy() {
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
}
