package com.example.aop_ex2.repository;

import com.example.aop_ex2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
