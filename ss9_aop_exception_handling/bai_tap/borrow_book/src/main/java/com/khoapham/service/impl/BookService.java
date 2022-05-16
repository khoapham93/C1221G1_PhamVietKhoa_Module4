package com.khoapham.service.impl;

import com.khoapham.exception.BookRunOut;
import com.khoapham.model.Books;
import com.khoapham.repository.IBookRepository;
import com.khoapham.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Books> findAll(Pageable pageInfo) {
        return this.iBookRepository.findAll(pageInfo);
    }

    @Override
    public Page<Books> search(String keyword, Pageable pageInfo) {
        return this.iBookRepository.findAllByNameContaining(keyword, pageInfo);
    }

    @Override
    public Books findById(int id) {
        return this.iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        this.iBookRepository.deleteById(id);
    }

    @Override
    public void borrow(Books books) throws BookRunOut {

        if (books.getId() != null && books.getAmount() > 0) {
            books.setAmount(books.getAmount() - 1);
            this.iBookRepository.save(books);
        } else {
            throw new BookRunOut();
        }

    }

    @Override
    public void returnBook(Books books) {
        if (books.getId() != null) {
            books.setAmount(books.getAmount() + 1);
        }
        this.iBookRepository.save(books);
    }

    @Override
    public void save(Books books) {

        this.iBookRepository.save(books);
    }
}



