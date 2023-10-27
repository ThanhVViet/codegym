package com.codegym.spring_data_jpa.repository;



import com.codegym.spring_data_jpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    // tạo method bằng method name
    List<Student> findStudentByNameContaining(String searchName);

    Page<Student> findStudentByNameContaining(Pageable pageable,String searchName);

    // tạo câu query thuần
    @Query(value = "select * from student where name like :searchName",nativeQuery = true)
    List<Student> searchByName(@Param("searchName")String searName);
}
