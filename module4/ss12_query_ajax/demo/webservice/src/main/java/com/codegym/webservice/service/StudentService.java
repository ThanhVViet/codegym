package com.codegym.webservice.service;

import com.codegym.webservice.model.Student;
import com.codegym.webservice.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    // DI interface
    @Autowired
    private IStudentRepository studentRepository ;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable,String name) {
        return studentRepository.findAllByNameContaining(pageable,name);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> search(String name) {
        return studentRepository.searchByName("%"+name+"%");
    }
    @Override
    public boolean save(Student student)  {
        Student student1 =studentRepository.save(student);
        return student1!=null;
    }

    @Override
    public boolean delete(int id) {
        try {
            studentRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
