package com.khoapham.service;

import com.khoapham.exception.BookRunOut;
import com.khoapham.model.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    Page<Books> findAll(Pageable pageInfo);

    Page<Books> search(String keyword, Pageable pageInfo);

    Books findById(int id);

    void remove(int id);

    void borrow(Books books) throws BookRunOut;

    void returnBook(Books books);

    void save(Books books);


}
