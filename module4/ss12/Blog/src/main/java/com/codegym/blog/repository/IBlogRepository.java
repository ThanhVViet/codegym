package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findBlogByTitleContaining(Pageable pageable, String searchTitle);
    @Query(value = "select * from blog where id_category like :id_category",nativeQuery = true)
    Page<Blog> findByCategory(Pageable pageable, @Param("id_category")Integer id_category);

    @Query(value = "select * from blog where id_category like :id_category",nativeQuery = true)
    List<Blog> findBlogByCategory(@Param("id_category")Integer id_category);
    @Query(value = "select * from blog where title like :search",nativeQuery = true)
    List<Blog> findSearch(@Param("search")String search);
}
