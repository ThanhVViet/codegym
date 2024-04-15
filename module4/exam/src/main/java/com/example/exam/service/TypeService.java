package com.example.exam.service;

import com.example.exam.model.QuestionType;
import com.example.exam.repository.ITypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService implements IType{
    private ITypeRepo iTypeRepo;

    @Autowired
    public TypeService(ITypeRepo iTypeRepo) {
        this.iTypeRepo = iTypeRepo;
    }

    @Override
    public List<QuestionType> findAll() {
        return iTypeRepo.findAll();
    }

    @Override
    public Optional<QuestionType> findById(int id) {
        return iTypeRepo.findById(id);
    }
}
