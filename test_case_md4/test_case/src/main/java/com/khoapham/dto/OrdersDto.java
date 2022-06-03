package com.khoapham.dto;

import com.khoapham.model.Product;
import com.khoapham.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class OrdersDto implements Validator {
    private Integer id;
    private LocalDate dateBuy;
    private Integer quantity;
    @NotNull(message = "{object.empty} product")
    private Product product;

    public OrdersDto(Integer id, LocalDate dateBuy, Integer quantity, Product product) {
        this.id = id;
        this.dateBuy = dateBuy;
        this.quantity = quantity;
        this.product = product;
    }

    public OrdersDto(LocalDate dateBuy, Integer quantity, Product product) {

        this.dateBuy = dateBuy;
        this.quantity = quantity;
        this.product = product;
    }

    public OrdersDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(LocalDate dateBuy) {
        this.dateBuy = dateBuy;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrdersDto ordersDto = (OrdersDto) target;

        LocalDate dateBuy = ordersDto.getDateBuy();
        Validation.checkStartDate("dateBuy", dateBuy, errors);
        Integer quantity = ordersDto.getQuantity();
        Validation.checkPositiveInteger("quantity", quantity, errors);
    }
}
