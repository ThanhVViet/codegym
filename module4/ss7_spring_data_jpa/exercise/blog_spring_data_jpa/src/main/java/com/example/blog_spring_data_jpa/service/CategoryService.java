package com.example.blog_spring_data_jpa.service;


import com.example.blog_spring_data_jpa.model.Category;
import com.example.blog_spring_data_jpa.repository.ICategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private ICategoryRepository iCategoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable, String searchName) {
        return null;
    }



    @Override
    @Transactional
    public boolean add(Category category) {
        Category newCategory = iCategoryRepository.save(category);
        return (newCategory != null);
    }

    @Override
    @Transactional
    public Category update(Category category) {
        return iCategoryRepository.saveAndFlush(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id).orElse(null);
    }
}
