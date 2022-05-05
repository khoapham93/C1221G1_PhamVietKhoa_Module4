package com.khoapham.service;

import com.khoapham.model.Product;


import java.util.List;


public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
