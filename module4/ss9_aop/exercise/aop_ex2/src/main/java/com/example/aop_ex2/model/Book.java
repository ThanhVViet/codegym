package com.example.aop_ex2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_borrow")
    private String idBorrow;
    @Column(name = "number_of_book")
    private int numberOfBook;

    private String name;

    public Book() {
    }

    public Book(Integer id, String idBorrow, int numberOfBook) {
        this.id = id;
        this.idBorrow = idBorrow;
        this.numberOfBook = numberOfBook;
    }

    public Book(Integer id, String idBorrow, int numberOfBook, String name) {
        this.id = id;
        this.idBorrow = idBorrow;
        this.numberOfBook = numberOfBook;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(String idBorrow) {
        this.idBorrow = idBorrow;
    }

    public int getNumberOfBook() {
        return numberOfBook;
    }

    public void setNumberOfBook(int numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", idBorrow='" + idBorrow + '\'' +
                ", numberOfBook=" + numberOfBook +
                ", name='" + name + '\'' +
                '}';
    }

}
