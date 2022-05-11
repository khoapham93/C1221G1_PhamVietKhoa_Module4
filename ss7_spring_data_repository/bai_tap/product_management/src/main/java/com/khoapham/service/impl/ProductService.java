package com.khoapham.service.impl;

import com.khoapham.model.Product;
import com.khoapham.repository.IProductRepository;
import com.khoapham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return this.iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        this.iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByNameAndManufacturerAndPrice(String keyWord1, String keyWord2, String keyWord3, Pageable pageable) {
        return this.iProductRepository.findAllByNameContainingAndManufacturerContainingAndDescriptionContaining(keyWord1, keyWord2, keyWord3, pageable);

    }

}
