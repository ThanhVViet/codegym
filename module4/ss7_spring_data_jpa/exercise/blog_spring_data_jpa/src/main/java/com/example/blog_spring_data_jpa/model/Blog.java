package com.example.blog_spring_data_jpa.model;

import jakarta.persistence.*;


@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    @Column(name = "header_of_blog")
    private String headerOfBlog;
    private String content;
    private Double price;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    public Blog(String author, String headerOfBlog, String content, Category category) {
        this.author = author;
        this.headerOfBlog = headerOfBlog;
        this.content = content;
        this.category = category;
    }

    public Blog(int id, String author, String headerOfBlog, String content, Category category) {
        this.id = id;
        this.author = author;
        this.headerOfBlog = headerOfBlog;
        this.content = content;
        this.category = category;
    }

    public Blog(Integer id, String author, String headerOfBlog, String content, Double price, Category category) {
        this.id = id;
        this.author = author;
        this.headerOfBlog = headerOfBlog;
        this.content = content;
        this.price = price;
        this.category = category;
    }

    public Blog() {
    }

    public Blog(int id, String author, String headerOfBlog, String content) {
        this.id = id;
        this.author = author;
        this.headerOfBlog = headerOfBlog;
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHeaderOfBlog() {
        return headerOfBlog;
    }

    public void setHeaderOfBlog(String headerOfBlog) {
        this.headerOfBlog = headerOfBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
