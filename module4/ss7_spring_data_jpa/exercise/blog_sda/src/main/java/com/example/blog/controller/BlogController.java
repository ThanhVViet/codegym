package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    private BlogService blogService;
    private CategoryService categoryService;

    @Autowired
    public BlogController(BlogService blogService, CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }


    @GetMapping("/home")
    public String list(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogs", blogList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "create";
    }

    @PostMapping("/create")
    public String add(Blog blog) {
        blogService.add(blog);
        return "redirect:/home";
    }

    @GetMapping("/{id}/update")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit", "blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(Blog blog) {
        blogService.edit(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/home", "product", blog);
        return modelAndView;
    }

    @GetMapping("/{id}/detail")
    public ModelAndView showFormDetail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail", "blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(Blog blog) {
        blogService.delete(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/home", "blog", blog);
        return modelAndView;
    }


}
