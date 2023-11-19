package com.example.blog_spring_data_jpa.service;


import com.example.blog_spring_data_jpa.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable, String searchName);
    boolean add(Category category);
    Category update(Category category);
    void deleteCategoryById(int id);

    Category findById(int id);
}
