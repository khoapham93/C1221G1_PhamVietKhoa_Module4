package com.khoapham.repository;

import com.khoapham.model.Product;
import com.khoapham.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByProductType(ProductType productType);
}
