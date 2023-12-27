package com.example.m5_cuoiki.controller;

import com.example.m5_cuoiki.model.Employee;
import com.example.m5_cuoiki.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

//    @GetMapping
//    public ResponseEntity<List<Employee>> findAll(@RequestParam String keyword) {
//        List<Employee> employees = iEmployeeService.findAll(keyword);
//        return ResponseEntity.ok(employees);
//    }
    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = iEmployeeService.findAll();
        return ResponseEntity.ok(employees);
    }


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee employeeDto = iEmployeeService.save(employee);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

}
