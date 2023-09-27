package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private IProductService iProductService;

    @Autowired
    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("/home")
    public String index(Model model) {
        List<Product> products = iProductService.findAll();
        model.addAttribute("products", products);
        return "index";
    }


    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create", "product", new Product());
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product) {
        product.setId((int) (Math.random() * 10000));
        iProductService.save(product);
        System.out.println(product);
        return "redirect:/product/home";
    }

    @GetMapping("/{id}/update")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("update", "product", iProductService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(Product product) {
        iProductService.update(product.getId(), product);
        ModelAndView modelAndView = new ModelAndView("redirect:/product/home", "product", product);
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView showFormView(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("view", "product", iProductService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product/home";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam("keyword") String keyword, Model model) {
        List<Product> searchResults;
        if (keyword != null && !keyword.isEmpty()) {
            searchResults = iProductService.search(keyword);

        } else {
            searchResults = iProductService.findAll();
        }
        model.addAttribute("products", searchResults);
        return "index";
    }

}
