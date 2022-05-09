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
public class ProductRepositoryImpl implements IProductRepository {
//
//    private static final Map<Integer, Product> products;
//
//    static {
//
//        products = new HashMap<>();
//        products.put(1, new Product(1, "John", 100000.0, "Hanoi", "Omo"));
//        products.put(2, new Product(2, "Bill", 20000.0, "Hanoi", "Omo"));
//        products.put(3, new Product(3, "Alex", 30000.0, "Hanoi", "Omo"));
//        products.put(4, new Product(4, "Adam", 500000.0, "Hanoi", "Omo"));
//        products.put(5, new Product(5, "Sophia", 9000000.0, "Hanoi", "Omo"));
//        products.put(6, new Product(6, "Rose", 500.0, "Hanoi", "Omo"));
//    }

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
        typedQuery.setParameter("name",keyWord);
        return typedQuery.getResultList();

//
//        List<Product> resultSearch = new ArrayList<>();
//        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
//            if (entry.getValue().getName().toLowerCase().contains(keyWord)) {
//                resultSearch.add(entry.getValue());
//            }
//        }
//        return resultSearch;
    }
}
