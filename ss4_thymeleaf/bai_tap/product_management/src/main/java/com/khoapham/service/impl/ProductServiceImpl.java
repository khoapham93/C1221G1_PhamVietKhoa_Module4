package com.khoapham.service.impl;

import com.khoapham.model.Product;
import com.khoapham.repository.IProductRepository;
import com.khoapham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

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
        return this.iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        this.iProductRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        this.iProductRepository.remove(id);
    }

    @Override
    public List<Product> search(String keyWord) {
        return this.iProductRepository.search(keyWord);
    }
}
