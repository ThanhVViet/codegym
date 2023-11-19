package com.example.webservice.controller;

import com.example.webservice.model.Category;
import com.example.webservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private ICategoryService iCategoryService;

    @Autowired
    public CategoryController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }
    @GetMapping()
    public ResponseEntity<List<Category>> home(){
        List<Category> customers = iCategoryService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Category> add(@RequestBody Category category){
        return new ResponseEntity<>(iCategoryService.save(category), HttpStatus.CREATED);
    }

}
