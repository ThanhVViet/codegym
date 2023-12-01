package com.example.blog_spring_data_jpa.controller;

import com.example.blog_spring_data_jpa.model.Blog;
import com.example.blog_spring_data_jpa.model.Category;
import com.example.blog_spring_data_jpa.service.IBlogService;
import com.example.blog_spring_data_jpa.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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


        @GetMapping("/home")
    public String showHome(Model model) {
        String keyword ="g";
        return list(model, 1, "author", "asc", keyword);
    }

    //    @GetMapping("/page/{pageNumber}")
//    public String list(
//            Model model,
//            @PathVariable("pageNumber") int currentPage,
//            @Param("sortField") String sortField,
//            @Param("sortDirection") String sortDir) {
//        Page<Blog> blogList = blogService.findAllPage(currentPage, sortField, sortDir);
//        long totalItem = blogList.getTotalElements();
//        int totalPage = blogList.getTotalPages();
//        model.addAttribute("blogs", blogList);
//        List<Category> categories = categoryService.findAll();
//        model.addAttribute("categories", categories);
//        model.addAttribute("totalItem", totalItem);
//        model.addAttribute("currentPage", currentPage);
//        model.addAttribute("totalPage", totalPage);
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("sortDir", sortDir);
//
//        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
//        model.addAttribute("reverseSortDir", reverseSortDir);
//        return "index";
//    }

    //main
//    @GetMapping("/home")
//    public String showList(@PageableDefault(page = 0, size = 5, sort = "author", direction = Sort.Direction.ASC) Pageable pageable,
//                           @RequestParam(defaultValue = "", required = false) String searchName,
//                           @RequestParam(defaultValue = "0", required = false) int key,
////                           @RequestParam(defaultValue = "", required = false) Integer key,
//                           Model model) {
//
//        Page<Blog> blogs;
//        if (key == 0) {
//            blogs = blogService.findAll(pageable, searchName);
//        } else {
//            blogs = blogService.getBlogByCat(pageable, key);
//        }
//
//        List<Category> categories = categoryService.findAll();
//        model.addAttribute("categories", categories);
//        model.addAttribute("key", key);
//        model.addAttribute("blogs", blogs);
//        model.addAttribute("searchName", searchName);
//        return "index";
//    }


//    @GetMapping("/home")
//    public String viewHomePage(Model model, @Param("searchName") String searchName) {
//        List<Blog> blogList = blogService.findAll(searchName);
//        model.addAttribute("blogs", blogList);
//        List<Category> categories = categoryService.findAll();
//        model.addAttribute("categories", categories);
//        model.addAttribute("searchName",searchName);
//        return "index";
//    }
    @GetMapping("/page/{pageNumber}")

    public String list( Model model,
                       @PathVariable("pageNumber") int currentPage,
                       @Param("sortField") String sortField,
                       @Param("sortDir") String sortDir,
                       @Param("keyword") String keyword) {

        Page<Blog> blogList = blogService.findAllPage(currentPage,sortField, sortDir, keyword);
        long totalItem = blogList.getTotalElements();
        int totalPage = blogList.getTotalPages();
        model.addAttribute("blogs", blogList);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("totalItem", totalItem);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("sortField", sortField);
        return "index";
    }

//    public String list(@PageableDefault(page = 0, size = 5) Pageable pageable,
//                       @PathVariable("pageNumber") int currentPage,
//                       @Param("sortField") String sortField,
//                       @Param("sortDir") String sortDir,
//                       Model model,
//                       @RequestParam(defaultValue = "", required = false) String searchName,
//             @Param("keyword") String keyword) {
//
//        Page<Blog> blogList = blogService.findAllPage(currentPage,sortField, sortDir, keyword);
//        long totalItem = blogList.getTotalElements();
//        int totalPage = blogList.getTotalPages();
//        model.addAttribute("blogs", blogList);
//        List<Category> categories = categoryService.findAll();
//        model.addAttribute("categories", categories);
//        model.addAttribute("totalItem", totalItem);
//        model.addAttribute("currentPage", currentPage);
//        model.addAttribute("totalPage", totalPage);
//        model.addAttribute("keyword", keyword);
//        return "index";
//    }

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
    public ModelAndView showFormEdit1(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit", "blog", blogService.findById(id));
        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/page/{id}/update")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit", "blog", blogService.findById(id));
        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(Blog blog) {
        blogService.update(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/home", "product", blog);
        return modelAndView;
    }

    @GetMapping("/{id}/detail")
    public ModelAndView showFormDetail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail", "blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Blog blog) {
        blogService.deleteBlogById(blog.getId());
        return "redirect:/home";
    }

//    @GetMapping("/search")
//    public ModelAndView search(@RequestParam int key) {
//        List<Blog> blogs;
//        if (key == 0) {
//            blogs = blogService.findAll();
//        } else {
//            blogs = blogService.getBlogByCat(key);
//        }
//        ModelAndView modelAndView = new ModelAndView("index", "blogs", blogs);
//        modelAndView.addObject("key", key);
//        List<Category> categories = categoryService.findAll();
//        modelAndView.addObject("categories", categories);
//        return modelAndView;
//    }


}
