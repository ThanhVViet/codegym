package com.codegym.webservice.service;

import com.codegym.webservice.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable,String name);
    Page<Student> findAll(Pageable pageable);
    List<Student> search(String name);
    boolean save(Student student) ;
    boolean delete(int id) ;
    Student findById(int id);
}
