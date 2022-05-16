package com.khoapham.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private Integer amount;
    @OneToMany(mappedBy = "book")
    private Set<BookBorrow> bookBorrowSet;

    public Books() {
    }

    public Books(Integer id, String name, String author, Integer amount, Set<BookBorrow> bookBorrowSet) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.amount = amount;
        this.bookBorrowSet = bookBorrowSet;
    }

    public Books(String name, String author, Integer amount, Set<BookBorrow> bookBorrowSet) {

        this.name = name;
        this.author = author;
        this.amount = amount;
        this.bookBorrowSet = bookBorrowSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}