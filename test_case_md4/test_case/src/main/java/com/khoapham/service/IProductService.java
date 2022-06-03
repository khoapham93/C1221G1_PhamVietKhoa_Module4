package com.khoapham.service;

import com.khoapham.model.Product;
import com.khoapham.model.ProductType;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    List<Product> findByProductType(ProductType productType);
}
