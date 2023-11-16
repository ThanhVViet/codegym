package com.example.cart.controller;

import com.example.cart.model.Category;
import com.example.cart.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private ICategoryService iCategoryService;

    @Autowired

    public CategoryController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @GetMapping("")
    public ModelAndView homePage() {
        ModelAndView modelAndView1 = new ModelAndView("category/index");
        modelAndView1.addObject("categories", iCategoryService.findAll());
        return modelAndView1;
    }
    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView1 = new ModelAndView("category/test");
        modelAndView1.addObject("categories", iCategoryService.findAll());
        return modelAndView1;
    }


    @GetMapping("/create")
    public ModelAndView createPage() {
        return new ModelAndView("category/create", "category", new Category());
    }

    @PostMapping
    public ModelAndView add(Category category) {
        return new ModelAndView("redirect:/category", "category", iCategoryService.save(category));
    }

}
