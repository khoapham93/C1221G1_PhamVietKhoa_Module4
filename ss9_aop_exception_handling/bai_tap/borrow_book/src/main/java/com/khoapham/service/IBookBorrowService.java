package com.khoapham.service;

import com.khoapham.exception.NotFindBrorrowCode;
import com.khoapham.model.BookBorrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookBorrowService {
    Page<BookBorrow> findAll(Pageable pageInfo);

    Page<BookBorrow> search(Integer bookId, Pageable pageInfo);

    BookBorrow findById(int id);

    BookBorrow findByCode(String code) throws NotFindBrorrowCode;

    void remove(int id);

    void remove(BookBorrow bookBorrow);

    void save(BookBorrow bookBorrow);

}
