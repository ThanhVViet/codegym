package com.example.webservice.controller;

import ch.qos.logback.core.model.Model;
import com.example.webservice.model.Blog;
import com.example.webservice.model.Category;
import com.example.webservice.repository.IBlogRepository;
import com.example.webservice.service.IBlogService;
import com.example.webservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    private ICategoryService iCategoryService;
    private IBlogService iBlogService;

    @Autowired
    public BlogController(ICategoryService iCategoryService, IBlogService iBlogService) {
        this.iCategoryService = iCategoryService;
        this.iBlogService = iBlogService;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> home(){
        List<Blog> blogList = iBlogService.findAll();
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Blog> add(@RequestBody Blog blog){
        Blog newBlog = iBlogService.save(blog);
        return new ResponseEntity<>( newBlog,HttpStatus.CREATED);
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<List<Blog>> getBlogByCategory(@PathVariable int id){
        return new ResponseEntity<>( iBlogService.findById(id),HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Optional<Blog>> detail(@PathVariable int id){
        return new ResponseEntity<>( iBlogService.detail(id),HttpStatus.OK);
    }
}
