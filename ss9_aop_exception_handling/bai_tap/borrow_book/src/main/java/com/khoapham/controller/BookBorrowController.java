package com.khoapham.controller;

import com.khoapham.exception.BookRunOut;
import com.khoapham.exception.NotFindBrorrowCode;
import com.khoapham.model.BookBorrow;
import com.khoapham.model.Books;
import com.khoapham.service.IBookBorrowService;
import com.khoapham.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class BookBorrowController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IBookBorrowService iBookBorrowService;

    @GetMapping("")
    public String index(Model model,
                        @PageableDefault(value = 5) Pageable pageable) {
        Page<Books> books = iBookService.findAll(pageable);
        model.addAttribute("books", books);
        return "/index";
    }

    @GetMapping("/{id}/detail")
    public String detail(Model model,
                         @PathVariable int id) {
        Books book = this.iBookService.findById(id);
        model.addAttribute("book", book);
        return "/view";
    }

    @PostMapping("/borrow")
    public String borrowBook(@ModelAttribute Books book, Model model) throws BookRunOut{
        this.iBookService.borrow(book);
        BookBorrow bookBorrow = new BookBorrow();
        bookBorrow.setBook(book);
        this.iBookBorrowService.save(bookBorrow);
        model.addAttribute("codeBorrow", bookBorrow.getCodeBorrow());
        return "borrow_success";

    }

    @GetMapping("/return")
    public String showReturn() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String borrowCode, Model model) throws NotFindBrorrowCode {
        BookBorrow bookBorrow = this.iBookBorrowService.findByCode(borrowCode);
        this.iBookBorrowService.remove(bookBorrow);
        this.iBookService.returnBook(bookBorrow.getBook());
        return "return_success";
    }

    @ExceptionHandler(NotFindBrorrowCode.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("notfound");
    }
    @ExceptionHandler(BookRunOut.class)
    public ModelAndView showBorrowFail() {
        return new ModelAndView("borrow_fail");
    }
}
