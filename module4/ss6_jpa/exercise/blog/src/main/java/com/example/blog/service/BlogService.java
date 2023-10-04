package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("from Blog", Blog.class);
        return query.getResultList();

    }

    @Transactional
    public void add(Blog blog) {
        entityManager.persist(blog);
    }

    @Transactional
    public void edit(Blog blog) {
        Blog editBlog = findById(blog.getId());
        BeanUtils.copyProperties(blog, editBlog);
        entityManager.merge(editBlog);
    }

    public Blog findById(int id) {
        return entityManager.find(Blog.class, id);
    }

    @Transactional
    public void delete(Blog blog) {
        Blog delBlog = findById(blog.getId());
        entityManager.remove(delBlog);
    }


}
