package com.codegym.spring_data_jpa.service;



import com.codegym.spring_data_jpa.exception.DuplicateAdminName;
import com.codegym.spring_data_jpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable, String searchName);
    List<Student> search(String searchName);

    boolean add(Student student) throws DuplicateAdminName;

    Student findById(int id);
}
