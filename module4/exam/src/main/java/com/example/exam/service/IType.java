package com.example.exam.service;

import com.example.exam.model.QuestionType;

import java.util.List;
import java.util.Optional;

public interface IType {
    List<QuestionType> findAll();
    Optional<QuestionType> findById(int id);
}
