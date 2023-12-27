package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;

import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

import java.util.List;
@RestController

@RequestMapping("/api")
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
//    @GetMapping("/list")
//    public String showListAndSearch(@RequestParam(defaultValue = "0",required = false) int page,
//                           @RequestParam(defaultValue = "",required = false) String searchTitle, Model model) {
//        Pageable pageable = PageRequest.of(page,5 , Sort.by("dateCreate").ascending());
//        Page<Blog> blogPage = iBlogService.findAll(pageable,searchTitle);
//        List<Category> categoryList = iCategoryService.findAll();
//        model.addAttribute("categoryList",categoryList);
//        model.addAttribute("blogPage",blogPage);
//        model.addAttribute("searchTitle",searchTitle);
//        return "display";
//    }
//    @GetMapping("/category/{id_category}")
//    public String showCategory(@RequestParam(defaultValue = "0",required = false) int page,
//                                    @RequestParam(defaultValue = "",required = false) String searchTitle,
//                               @PathVariable Integer id_category, Model model) {
//        Pageable pageable = PageRequest.of(page,2, Sort.by("date_create").ascending());
//        Page<Blog> blogPage = iBlogService.findByCategory(pageable,id_category);
//        List<Category> categoryList = iCategoryService.findAll();
//        model.addAttribute("categoryList",categoryList);
//        model.addAttribute("blogPage",blogPage);
//        model.addAttribute("searchTitle",searchTitle);
//        return "display";
//    }
//    @GetMapping("/create")
//    public String showCreate(Model model){
//        List<Category> listCategory = iCategoryService.findAll();
//        model.addAttribute("listCategory",listCategory);
//        LocalDate now = LocalDate.now();
//        Blog blog = new Blog();
//        blog.setDateCreate(now);
//        model.addAttribute("blog",blog);
//        return "create";
//    }
//    @PostMapping("/create")
//    public String Create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
//        iBlogService.save(blog);
//        redirectAttributes.addFlashAttribute("mess","create success");
//        return "redirect:/list";
//    }
//    @GetMapping("/read/{id}")
//    public String showRead(@PathVariable Integer id,Model model){
//        Blog blog = iBlogService.findById(id);
//        model.addAttribute("blog",blog);
//        return "read";
//    }
//    @GetMapping("/update/{id}")
//    public String showUpdate(@PathVariable Integer id,Model model){
//        List<Category> listCategory = iCategoryService.findAll();
//        model.addAttribute("listCategory",listCategory);
//        Blog blog = iBlogService.findById(id);
//        model.addAttribute("blog",blog);
//        return "update";
//    }
//    @PostMapping("/update")
//    public String Update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
//        iBlogService.save(blog);
//        redirectAttributes.addFlashAttribute("mess","update success");
//        return "redirect:/list";
//    }
//    @GetMapping("/remove/{id}")
//    public String Remove(@PathVariable Integer id, RedirectAttributes redirectAttributes){
//        Blog blog = iBlogService.findById(id);
//        iBlogService.remove(id);
//        redirectAttributes.addFlashAttribute("mess","remove success");
//        return "redirect:/list";
//    }
    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> getCa(){
        List<Category> categoryList = iCategoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);//200
    }
    @GetMapping("/listBlog")
    public ResponseEntity<List<Blog>> getBl(){
        List<Blog> blogList = iBlogService.findAll();
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/listBlogOfCategory/{id}")
    public ResponseEntity<List<Blog>> blogOfId(@PathVariable Integer id){
        List<Blog> blogList = iBlogService.findBlogByCategory(id);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> detail(@PathVariable Integer id){
        Blog blog = iBlogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @GetMapping("/pages")
    public ResponseEntity<Page<Blog>> getPage(@RequestParam(defaultValue = "0",required = false) int page){
        Pageable pageable = PageRequest.of(page,2, Sort.by("userName").ascending());
        Page<Blog> blogPage = iBlogService.findAll(pageable);
        if(blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);//200
    }
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam(defaultValue = "0",required = false) String search){
        List<Blog> blogList = iBlogService.search(search);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
