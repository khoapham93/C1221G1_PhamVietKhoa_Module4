package com.khoapham.service.impl;

import com.khoapham.dto.ProductDto;
import com.khoapham.model.Product;
import com.khoapham.repository.IProductRepository;
import com.khoapham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
    public void checkExists(ProductDto productDto, BindingResult bindingResult) {
        Product product = this.iProductRepository.findFirstByImei(productDto.getImei());

        if (productDto.getId() == null) {
            //Add new
            if (!"".equals(productDto.getImei())) {
                if (product != null) {
                    bindingResult.rejectValue("imei", "imei.exists");
                }
            }
        } else {
            //update
            if (product.getId().equals(productDto.getId())) {
                bindingResult.rejectValue("imei", "imei.exists");
            }
        }
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
    public Page<Product> findAllByNameAndManufacturerAndPrice(String keyWord1, int keyWord2, String keyWord3, Pageable pageable) {
        if (keyWord2 == -1) {
            return this.iProductRepository.findAllByNameContainingAndDescriptionContaining(keyWord1, keyWord3, pageable);
            //call method not include Manufacturer
        } else {
            return this.iProductRepository.findAllByNameContainingAndManufacturer_IdAndDescriptionContaining(keyWord1, keyWord2, keyWord3, pageable);
        }
    }

}
