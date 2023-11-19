package com.example.webservice.service;



import com.example.webservice.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    List<Blog> findById(int id);
    Blog save(Blog blog);
    Optional<Blog> detail(int id);


}
