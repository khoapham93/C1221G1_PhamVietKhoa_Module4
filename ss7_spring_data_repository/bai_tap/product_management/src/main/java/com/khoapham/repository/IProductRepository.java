package com.khoapham.repository;

import com.khoapham.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByNameContainingAndManufacturerContainingAndDescriptionContaining(String keyWord1, String keyWord2, String keyWord3, Pageable Pageable);
}
