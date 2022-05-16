package com.khoapham.service.impl;

import com.khoapham.exception.NotFindBrorrowCode;
import com.khoapham.model.BookBorrow;
import com.khoapham.repository.IBookBorrowRepository;
import com.khoapham.repository.IBookRepository;
import com.khoapham.service.IBookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookBorrowService implements IBookBorrowService {
    @Autowired
    private IBookBorrowRepository iBookBorrowRepository;

    @Override
    public Page<BookBorrow> findAll(Pageable pageInfo) {
        return this.iBookBorrowRepository.findAll(pageInfo);
    }

    @Override
    public Page<BookBorrow> search(Integer bookId, Pageable pageInfo) {
        return this.iBookBorrowRepository.findAllByBook_Id(bookId,pageInfo);
    }

    @Override
    public BookBorrow findById(int id) {
        return this.iBookBorrowRepository.findById(id).orElse(null);
    }

    @Override
    public BookBorrow findByCode(String code) throws NotFindBrorrowCode {
        BookBorrow bookBorrow = this.iBookBorrowRepository.findFirstByCodeBorrow(code);

        if (bookBorrow !=null){
            return bookBorrow;
        }else {
            throw new NotFindBrorrowCode();
        }
    }

    @Override
    public void remove(int id) {
        //set status to false;

    }

    @Override
    public void remove(BookBorrow bookBorrow) {
        this.iBookBorrowRepository.delete(bookBorrow);
    }

    @Override
    public void save(BookBorrow bookBorrow) {
        int codeBorrow = (int)(Math.floor(Math.random()*1000) + 9999);
        String code = Integer.toString(codeBorrow);
        bookBorrow.setCodeBorrow(code);
        bookBorrow.setStatus(true);

        this.iBookBorrowRepository.save(bookBorrow);
    }
}
