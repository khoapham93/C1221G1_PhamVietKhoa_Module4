package com.khoapham.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String descriptionBlog;
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "catelogy_id", referencedColumnName = "id")
    private Catelogy catelogy;

    public Blog() {
    }

    public Blog(String name, Double price, String descriptionBlog, String manufacturer, Catelogy catelogy) {

        this.name = name;
        this.price = price;
        this.descriptionBlog = descriptionBlog;
        this.manufacturer = manufacturer;
        this.catelogy = catelogy;
    }

    public Blog(Integer id, String name, Double price, String descriptionBlog, String manufacturer, Catelogy catelogy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.descriptionBlog = descriptionBlog;
        this.manufacturer = manufacturer;
        this.catelogy = catelogy;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescriptionBlog() {
        return descriptionBlog;
    }

    public void setDescriptionBlog(String descriptionBlog) {
        this.descriptionBlog = descriptionBlog;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Catelogy getCatelogy() {
        return catelogy;
    }

    public void setCatelogy(Catelogy catelogy) {
        this.catelogy = catelogy;
    }
}