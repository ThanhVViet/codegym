package com.example.exam.service;


import com.example.exam.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContent {
    Page<QuestionContent> findAll(Pageable pageable, String searchName);
    boolean add(QuestionContent questionContent);
    Page<QuestionContent> getBlogByCat(Pageable pageable, int id);
    void deleteBlogById(int id);

}
