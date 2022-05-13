package com.khoapham.dto;

import com.khoapham.model.Manufacturer;
import com.khoapham.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class ProductDto implements Validator {
    private Integer id;
    private String name;
    private Double price;
    private String imei;
    private String description;
    private Manufacturer manufacturer;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Double price, String imei, String description, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imei = imei;
        this.description = description;
        this.manufacturer = manufacturer;
    }
    public ProductDto( String name, Double price, String imei, String description, Manufacturer manufacturer) {

        this.name = name;
        this.price = price;
        this.imei = imei;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        String regexSpecialChar = "^(\\p{L}|\\d)+( (\\p{L}|\\d)+)*$";

        if ("".equals(productDto.getName())){
            errors.rejectValue("name","name.empty");
        }else if (!productDto.getName().matches(regexSpecialChar)){
            errors.rejectValue("name","name.char");
        }

        if (productDto.getPrice()== null){
            errors.rejectValue("price","price.empty");
        }else if (productDto.getPrice() <0){
            errors.rejectValue("price","price.negative");
        }

        if ("".equals(productDto.imei)){
            errors.rejectValue("imei","imei.empty");
        }

        if (productDto.getManufacturer() == null){
            errors.rejectValue("manufacturer","manufacturer.invalid");
        }
    }
}
