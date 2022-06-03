package com.khoapham.repository;

import com.khoapham.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "SELECT od.*\n" +
            "FROM orders od\n" +
            "         INNER JOIN product p ON od.product_id = p.id\n" +
            "         INNER JOIN product_type pt ON p.product_type_id = pt.id\n" +
            "WHERE date_buy BETWEEN :from AND :to",
            countQuery = "SELECT od.*\n" +
                    "FROM orders od\n" +
                    "         INNER JOIN product p ON od.product_id = p.id\n" +
                    "         INNER JOIN product_type pt ON p.product_type_id = pt.id\n" +
                    "WHERE date_buy BETWEEN :from AND :to", nativeQuery = true)
    Page<Orders> findAll(@Param("from") String from, @Param("to") String to, Pageable pageable);

    @Query(value = "SELECT od.*\n" +
            "FROM orders od\n" +
            "         INNER JOIN product p ON od.product_id = p.id\n" +
            "         INNER JOIN product_type pt ON p.product_type_id = pt.id\n" +
            "WHERE date_buy BETWEEN :from AND :to\n" +
            "ORDER BY (od.quantity*p.price) DESC ",
            countQuery = "SELECT od.*\n" +
                    "FROM orders od\n" +
                    "         INNER JOIN product p ON od.product_id = p.id\n" +
                    "         INNER JOIN product_type pt ON p.product_type_id = pt.id\n" +
                    "WHERE date_buy BETWEEN :from AND :to\n" +
                    "ORDER BY (od.quantity*p.price) DESC ", nativeQuery = true)
    Page<Orders> findAllOrderTop(@Param("from") String from, @Param("to") String to, Pageable pageable);
}
