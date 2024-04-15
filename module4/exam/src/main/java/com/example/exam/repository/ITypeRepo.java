package com.example.exam.repository;

import com.example.exam.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepo extends JpaRepository<QuestionType,Integer> {
}
