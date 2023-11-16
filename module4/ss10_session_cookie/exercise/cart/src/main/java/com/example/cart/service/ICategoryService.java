package com.example.cart.service;

import com.example.cart.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Category save(Category category);
    Optional<Category> getCategoryById(long id);


}
