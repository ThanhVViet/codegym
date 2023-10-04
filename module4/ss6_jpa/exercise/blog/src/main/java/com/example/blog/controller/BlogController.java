package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/home")
    public ModelAndView list() {
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("index", "blogs", blogList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create", "blog", new Blog());
        return modelAndView;
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
