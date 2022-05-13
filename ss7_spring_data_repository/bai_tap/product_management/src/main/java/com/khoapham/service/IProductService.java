package com.khoapham.service;

import com.khoapham.dto.ProductDto;
import com.khoapham.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Boolean checkExists(ProductDto productDto);

    Product findById(int id);

    void remove(int id);

    Page<Product> findAllByNameAndManufacturerAndPrice(String keyWord1, int keyWord2, String keyWord3, Pageable pageable);
}
