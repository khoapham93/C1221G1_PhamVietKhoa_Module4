package com.khoapham.demo.service;

import com.khoapham.model.Product;

import java.util.List;

public interface IBlogService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void remove(int id);

    List<Product> search(String keyWord);
}
