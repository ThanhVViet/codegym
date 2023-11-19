package com.example.blog_spring_data_jpa.controller;

import com.example.blog_spring_data_jpa.model.Blog;
import com.example.blog_spring_data_jpa.model.Category;
import com.example.blog_spring_data_jpa.service.IBlogService;
import com.example.blog_spring_data_jpa.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    private IBlogService blogService;
    private ICategoryService categoryService;


    @Autowired
    public BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<Blog>> getPage(@RequestParam(defaultValue = "0",required = false) int page){
        Pageable pageable = PageRequest.of(page,2, Sort.by("author").ascending());
        Page<Blog> blogPage = blogService.findAll(pageable);
        if(blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);//200
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam(defaultValue = "0",required = false) String search){
        List<Blog> blogList = blogService.findByAuthor(search);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }


}
