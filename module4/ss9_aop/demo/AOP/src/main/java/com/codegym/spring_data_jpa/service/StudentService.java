package com.codegym.spring_data_jpa.service;


import com.codegym.spring_data_jpa.exception.DuplicateAdminName;
import com.codegym.spring_data_jpa.model.Student;
import com.codegym.spring_data_jpa.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    // DI interface
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable,String searchName) {
        return studentRepository.findStudentByNameContaining(pageable,searchName);
    }

    @Override
    public List<Student> search(String searchName) {
        return studentRepository.searchByName("%"+searchName+"%");
    }

    @Override
    public boolean add(Student student) throws DuplicateAdminName {
        System.out.println(4/0);
        if (student.getName().equals("Admin")){
            throw new DuplicateAdminName("Trung ten Admin");
        }
        Student newStudent = studentRepository.save(student);
        return (newStudent!=null);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
