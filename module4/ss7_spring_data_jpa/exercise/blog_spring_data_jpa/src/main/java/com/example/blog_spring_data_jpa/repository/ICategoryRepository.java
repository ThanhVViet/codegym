package com.example.blog_spring_data_jpa.repository;

import com.example.blog_spring_data_jpa.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
