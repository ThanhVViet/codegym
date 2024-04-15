package com.example.exam.service;

import com.example.exam.model.QuestionContent;
import com.example.exam.repository.IContentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContentService implements IContent {
    private IContentRepo iContentRepo;

    @Autowired
    public ContentService(IContentRepo iContentRepo) {
        this.iContentRepo = iContentRepo;
    }

    @Override
    public Page<QuestionContent> findAll(Pageable pageable, String searchName) {
        return iContentRepo.findQuestionContentByTitleContainingIgnoreCase(pageable,searchName);
    }

    @Override
    @Transactional
    public boolean add(QuestionContent questionContent) {
        QuestionContent newBlog = iContentRepo.save(questionContent);
        return (newBlog != null);
    }

    @Override
    public Page<QuestionContent> getBlogByCat(Pageable pageable, int id) {
        return iContentRepo.getBlogByCat(pageable, id);
    }

    @Override
    public void deleteBlogById(int id) {
        iContentRepo.deleteById(id);
    }
}
