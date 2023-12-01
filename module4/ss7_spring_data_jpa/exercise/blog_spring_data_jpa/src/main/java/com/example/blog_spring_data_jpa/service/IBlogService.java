package com.example.blog_spring_data_jpa.service;

import com.example.blog_spring_data_jpa.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    List<Blog> findAll(String keyword);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAll(Pageable pageable, String searchName);
    Page<Blog> findAllPage(int pageNumber, String sortField, String sortDirection, String keyword);
    boolean add(Blog blog);
    Blog save(Blog blog);
    Blog update(Blog blog);
    void deleteBlogById(int id);

    Blog findById(int id);
    Page<Blog> getBlogByCat(Pageable pageable, int id);
}
