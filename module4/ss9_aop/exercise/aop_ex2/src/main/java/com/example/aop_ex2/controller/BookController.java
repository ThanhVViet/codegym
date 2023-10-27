package com.example.aop_ex2.controller;

import com.example.aop_ex2.exception.BookException;
import com.example.aop_ex2.model.Book;
import com.example.aop_ex2.model.Error;
import com.example.aop_ex2.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    private IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("index", "books", bookService.findAll());
        return modelAndView;

    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create", "book", new Book());
        return modelAndView;
    }

    @PostMapping("/create")
    public String save(Book book, Model model) {
        Book newBook = bookService.save(book);
        model.addAttribute("books", newBook);
        return "redirect:/book";
    }

    @GetMapping("/{id}/detail")
    public ModelAndView showFormDetail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("borrow", "book", bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam int id) {
        String idBorrow = bookService.salt();

        Book borrowBook = bookService.findById(id);

        if (borrowBook.getNumberOfBook() == 0) {
            try {
                throw new BookException("No More Book !!!");
            } catch (BookException e) {
                throw new RuntimeException(e);
            }
        }

        if (borrowBook.getIdBorrow() == null) {
            borrowBook.setIdBorrow(idBorrow);
        }

        borrowBook.setNumberOfBook(borrowBook.getNumberOfBook() - 1);

        bookService.save(borrowBook);
        return "redirect:/book";
    }

    @GetMapping("/{id}/return")
    public ModelAndView showFormReturn(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("return", "book", bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("id-borrow") String idBorrow, @RequestParam int id) throws BookException {
        Book borrowBook = bookService.findById(id);
        if(idBorrow.equals(borrowBook.getIdBorrow())){
            borrowBook.setNumberOfBook(borrowBook.getNumberOfBook()+1);
        } else {
            throw new BookException("Wrong Id Borrow !!!");
        }

        bookService.save(borrowBook);

        return "redirect:/book";
    }

    @ExceptionHandler
    public ResponseEntity<Error> catchError(Exception ex) {
        Error error = new Error(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


}
