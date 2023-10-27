package com.example.aop_ex2.service;

import com.example.aop_ex2.model.Book;
import com.example.aop_ex2.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements IBookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);

    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
    @Override
    public  String salt() {
        int min = 10000;
        int max = 99999;
        Random random = new Random();
        int loanCodeNumber = random.nextInt(max - min + 1) + min;

        String loanCode = String.valueOf(loanCodeNumber);
        return loanCode;
    }
}
