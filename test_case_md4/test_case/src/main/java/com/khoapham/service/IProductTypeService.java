package com.khoapham.service;

import com.khoapham.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();

    ProductType findById(Integer id);
}
