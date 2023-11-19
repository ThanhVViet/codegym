package com.codegym.webservice.service;

import com.codegym.webservice.model.ClassRoom;
import com.codegym.webservice.repository.IClassRepository;
import com.codegym.webservice.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository classRepository;

    @Override
    public List<ClassRoom> findAll() {
        return classRepository.findAll();
    }
}
