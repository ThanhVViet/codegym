package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String searchTitle) {
        return iBlogRepository.findBlogByTitleContaining(pageable,searchTitle);
    }
    public Page<Blog> findByCategory(Pageable pageable, Integer id_category){
        return iBlogRepository.findByCategory(pageable,id_category);
    }
    @Override
    public boolean save(Blog blog) {
        Blog newBlog = null;
        try {
             newBlog = iBlogRepository.save(blog);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return (newBlog!=null);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }
    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }
    public List<Blog> findBlogByCategory(Integer id_category){
        return iBlogRepository.findBlogByCategory(id_category);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> search(String search) {
        return iBlogRepository.findSearch(search);
    }
}
