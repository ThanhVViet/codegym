package com.example.aop_ex2.service;

import com.example.aop_ex2.model.Book;

import java.util.List;

public interface IBookService {
    Book save (Book book);
    List<Book> findAll();
    Book findById(int id);
    String salt();
}
