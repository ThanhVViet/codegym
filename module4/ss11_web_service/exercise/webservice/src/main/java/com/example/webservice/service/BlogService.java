package com.example.webservice.service;

import com.example.webservice.model.Blog;
import com.example.webservice.repository.IBlogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    private IBlogRepository iBlogRepository;
    @Autowired
    public BlogService(IBlogRepository iBlogRepository) {
        this.iBlogRepository = iBlogRepository;
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public List<Blog> findById(int id) {
        return iBlogRepository.findAllBlogByCategoryId(id);
    }


    @Override
    @Transactional
    public Blog save(Blog blog) {
        return iBlogRepository.save(blog);
    }

    @Override
    public Optional<Blog> detail(int id) {
        return iBlogRepository.findById(id);
    }
}
