package com.example.webservice.repository;

import com.example.webservice.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllBlogByCategoryId(@Param("id")Integer id);
}
