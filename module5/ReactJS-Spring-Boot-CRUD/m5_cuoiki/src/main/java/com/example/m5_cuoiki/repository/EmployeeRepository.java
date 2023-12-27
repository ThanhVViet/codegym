package com.example.m5_cuoiki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.m5_cuoiki.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT p FROM Employee p WHERE CONCAT(p.firstName, ' ', p.lastName, ' ', p.email) LIKE %?1%")
    List<Employee> findKeyWord(String keyword);
}
