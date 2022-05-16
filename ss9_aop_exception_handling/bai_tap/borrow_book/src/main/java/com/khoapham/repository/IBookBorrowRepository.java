package com.khoapham.repository;

import com.khoapham.model.BookBorrow;
import com.khoapham.model.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookBorrowRepository extends JpaRepository<BookBorrow, Integer> {
    Page<BookBorrow> findAllByBook_Id(Integer id, Pageable pageable);
    BookBorrow findFirstByCodeBorrow(String code);

}
