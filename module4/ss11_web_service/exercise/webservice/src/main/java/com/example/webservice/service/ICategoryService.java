package com.example.webservice.service;

import com.example.webservice.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Optional<Category> findById(Integer id);
    Category save (Category category);
}
