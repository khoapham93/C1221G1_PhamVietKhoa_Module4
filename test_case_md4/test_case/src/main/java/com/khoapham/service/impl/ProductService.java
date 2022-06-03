package com.khoapham.service.impl;

import com.khoapham.model.Product;
import com.khoapham.model.ProductType;
import com.khoapham.repository.IProductRepository;
import com.khoapham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public List<Product> findByProductType(ProductType productType) {
        return this.iProductRepository.findAllByProductType(productType);
    }
}
