package com.khoapham.service.impl;

import com.khoapham.model.Product;
import com.khoapham.repository.IProductRepository;
import com.khoapham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.iProductRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return this.iProductRepository.findById(id).orElse(null);
    }
}
