package com.example.blog_spring_data_jpa.controller;


import com.example.blog_spring_data_jpa.model.Category;
import com.example.blog_spring_data_jpa.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    private ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public ModelAndView listCategory() {
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("c_index", "categories", categories);
        return modelAndView;
    }

    @GetMapping("/create-category")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView("c_create", "category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public String add(Category category) {
        categoryService.add(category);
        return "redirect:/list";
    }

    @GetMapping("/{id}/update-category")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("c_edit", "category", categoryService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update-category")
    public String update(Category category) {
        categoryService.update(category);
        return "redirect:/list";
    }

    @PostMapping("/delete-category")
    public String delete(Category category) {
        categoryService.deleteCategoryById(category.getId());
        return "redirect:/list";
    }
}
