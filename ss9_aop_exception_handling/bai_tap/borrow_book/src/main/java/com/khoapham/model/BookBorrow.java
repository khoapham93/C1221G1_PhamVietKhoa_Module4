package com.khoapham.model;

import javax.persistence.*;

@Entity
@Table(name = "book_borrow")
public class BookBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codeBorrow;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books book;
    private boolean status;

    public BookBorrow() {
    }

    public BookBorrow(Integer id, String codeBorrow, Books book, boolean status) {
        this.id = id;
        this.codeBorrow = codeBorrow;
        this.book = book;
        this.status = status;
    }

    public BookBorrow(String codeBorrow, Books book, boolean status) {

        this.codeBorrow = codeBorrow;
        this.book = book;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeBorrow() {
        return codeBorrow;
    }

    public void setCodeBorrow(String codeBorrow) {
        this.codeBorrow = codeBorrow;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
