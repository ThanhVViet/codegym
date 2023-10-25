package com.example.blog.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String headerOfBlog;
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
