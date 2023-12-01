package com.example.blog_spring_data_jpa.dto;


import jakarta.validation.constraints.NotNull;

public class BlogDTO {
    private Integer id;
    @NotNull(message = "thông tin bắt buộc")
    private String author;

    private String headerOfBlog;
    private String content;
    private Double price;
    private Integer categotyId;

    public BlogDTO() {
    }

    public BlogDTO(Integer id, String author, String headerOfBlog, String content, Double price, Integer categotyId) {
        this.id = id;
        this.author = author;
        this.headerOfBlog = headerOfBlog;
        this.content = content;
        this.price = price;
        this.categotyId = categotyId;
    }

    public Integer getCategotyId() {
        return categotyId;
    }

    public void setCategotyId(Integer categotyId) {
        this.categotyId = categotyId;
    }

    public Integer getId() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
