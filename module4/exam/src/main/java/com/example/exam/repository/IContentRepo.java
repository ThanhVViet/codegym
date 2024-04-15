package com.example.exam.repository;

import com.example.exam.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContentRepo extends JpaRepository<QuestionContent, Integer> {
    @Query("SELECT b FROM QuestionContent b join b.type  join fetch b.type c where c.id = :id")
    Page<QuestionContent> getBlogByCat(Pageable pageable, @Param("id") int key);

    Page<QuestionContent> findQuestionContentByTitleContainingIgnoreCase(Pageable pageable, String searchName);
}
