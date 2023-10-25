package com.example.blog.service;


import com.example.blog.model.Category;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService   {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> findAll() {
        TypedQuery<Category> query = entityManager.createQuery("from Category", Category.class);
        return query.getResultList();
    }



    public Category findById(int id) {
        return entityManager.find(Category.class, id);
    }

    @Transactional
    public void add(Category category) {
        entityManager.persist(category);
    }


}
