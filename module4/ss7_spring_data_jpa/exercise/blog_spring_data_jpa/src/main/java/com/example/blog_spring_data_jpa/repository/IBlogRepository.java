package com.example.blog_spring_data_jpa.repository;

import com.example.blog_spring_data_jpa.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query("SELECT b FROM Blog b join b.category  join fetch b.category c where c.id = :id")
    Page<Blog> getBlogByCat(Pageable pageable,@Param("id") int key);

    Page<Blog> findBlogByHeaderOfBlogContainingIgnoreCase(Pageable pageable, String searchName);
    @Query("SELECT p FROM Blog p WHERE CONCAT(p.author, ' ', p.content, ' ', p.headerOfBlog, ' ', p.price) LIKE %?1%")

    List<Blog> findKeyWord(String keyword);

    @Query("SELECT p FROM Blog p WHERE CONCAT(p.author, ' ', p.content, ' ', p.headerOfBlog, ' ', p.price) LIKE %?1%")

    Page<Blog> search(Pageable pageable,String keyword);
}
