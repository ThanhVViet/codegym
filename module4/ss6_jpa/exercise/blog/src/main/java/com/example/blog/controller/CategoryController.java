package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public ModelAndView listCategory(){
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("c_index","categories", categories);
        return modelAndView;
    }
    @GetMapping("/create-category")
    public ModelAndView showAddForm(){
        ModelAndView modelAndView = new ModelAndView("c_create","category", new Category());
        return modelAndView;
    }
    @PostMapping("/create-category")
    public String add(Category category){
        categoryService.add(category);
        return "redirect:/list";
    }
}
