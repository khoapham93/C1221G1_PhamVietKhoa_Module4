package com.khoapham.repository;

import com.khoapham.model.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Books,Integer> {
    Page<Books> findAllByNameContaining(String name, Pageable pageable);
}
