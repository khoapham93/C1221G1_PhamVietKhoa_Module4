package com.khoapham.service;

import com.khoapham.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void remove(int id);

    Page<Product> findAllByNameAndManufacturerAndPrice(String keyWord1,String keyWord2,String keyWord3, Pageable pageable);
}
