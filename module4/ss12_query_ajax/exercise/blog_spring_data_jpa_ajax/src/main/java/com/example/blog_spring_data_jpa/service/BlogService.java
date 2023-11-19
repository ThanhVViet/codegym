package com.example.blog_spring_data_jpa.service;


import com.example.blog_spring_data_jpa.model.Blog;

import com.example.blog_spring_data_jpa.repository.IBlogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {

    private IBlogRepository iBlogRepository;

    @Autowired
    public BlogService(IBlogRepository iBlogRepository) {
        this.iBlogRepository = iBlogRepository;
    }

//    @Override
//    public List<Blog> findAll() {
//        if(key != 0){
//            iBlogRepository.getBlogByCat(key);
//        }
//        return iBlogRepository.findAll();
//    }


    @Override
    public List<Blog> findByAuthor(String name) {
        return iBlogRepository.findBlog(name);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String searchName) {
        return iBlogRepository.findBlogByHeaderOfBlogContainingIgnoreCase(pageable, searchName);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }


    @Override
    @Transactional
    public boolean add(Blog blog) {
        Blog newBlog = iBlogRepository.save(blog);
        return (newBlog != null);
    }

    @Override
    @Transactional
    public Blog update(Blog blog) {
        return iBlogRepository.saveAndFlush(blog);
    }

    @Override
    @Transactional
    public void deleteBlogById(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> getBlogByCat(Pageable pageable, int id) {
        return iBlogRepository.getBlogByCat(pageable,id);
    }
}
