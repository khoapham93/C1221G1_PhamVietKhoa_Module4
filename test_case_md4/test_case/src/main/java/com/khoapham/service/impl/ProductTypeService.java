package com.khoapham.service.impl;

import com.khoapham.model.ProductType;
import com.khoapham.repository.IProductTypeRepository;
import com.khoapham.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return this.iProductTypeRepository.findAll();
    }

    @Override
    public ProductType findById(Integer id) {
        return this.iProductTypeRepository.findById(id).orElse(null);
    }
}
