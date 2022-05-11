package com.khoapham.repository.impl;

import com.khoapham.model.Product;
import com.khoapham.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager
                .createQuery("select s from Product as s", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {

        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        if (product.getId() == null) {
            BaseRepository.entityManager.persist(product);
        } else {
            BaseRepository.entityManager.merge(product);

        }
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            BaseRepository.entityManager.remove(product);
            entityTransaction.commit();
        }
    }

    @Override
    public List<Product> search(String keyWord) {
        keyWord = keyWord.toLowerCase();

        TypedQuery<Product> typedQuery = BaseRepository.entityManager
                .createQuery("select s from Product as s where s.name like :name", Product.class);
        typedQuery.setParameter("name", "%" + keyWord + "%");
        return typedQuery.getResultList();

    }
}
