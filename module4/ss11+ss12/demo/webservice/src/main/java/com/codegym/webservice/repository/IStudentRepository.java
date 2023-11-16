package com.codegym.webservice.repository;


import com.codegym.webservice.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    // tạo method search
    List<Student> findAllByNameContaining(String name);
    Page<Student> findAllByNameContaining(Pageable pageable,String name);

    // tạo câu query thuần
    @Query(value = "select * from student where name like :name",
            nativeQuery = true)
    List<Student> searchByName(@Param("name") String name);
}
