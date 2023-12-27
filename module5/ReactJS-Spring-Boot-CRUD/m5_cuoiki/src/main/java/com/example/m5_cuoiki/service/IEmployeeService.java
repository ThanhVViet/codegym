package com.example.m5_cuoiki.service;

import com.example.m5_cuoiki.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    List<Employee> findAll(String keyword);
    Employee save(Employee employee);
}
