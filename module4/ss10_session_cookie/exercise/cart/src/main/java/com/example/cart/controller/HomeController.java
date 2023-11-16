package com.example.cart.controller;

import com.example.cart.dto.CartDTO;
import com.example.cart.service.ICategoryService;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
@SessionAttributes("cart")
public class HomeController {
    @ModelAttribute("cart")
    public CartDTO initCart() {
        return new CartDTO();
    }

    private ICategoryService iCategoryService;
    private IProductService iProductService;

    @Autowired
    public HomeController(ICategoryService iCategoryService, IProductService iProductService) {
        this.iCategoryService = iCategoryService;
        this.iProductService = iProductService;
    }

    @GetMapping("")
    public ModelAndView homePage() {
        return new ModelAndView("index");
    }

    @GetMapping("/product")
    public ModelAndView productPage(@SessionAttribute(value = "cart", required = false) CartDTO cartDTO) {
        ModelAndView modelAndView = new ModelAndView("product/index", "products", iProductService.findAll());
        if (cartDTO != null) {
            modelAndView.addObject("cart", cartDTO);
        }
        return modelAndView;
    }

    @GetMapping("/category")
    public ModelAndView categoryPage() {
        return new ModelAndView("category/index", "categories", iCategoryService.findAll());
    }

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView1 = new ModelAndView("category/test");
        modelAndView1.addObject("categories", iCategoryService.findAll());
        return modelAndView1;
    }

}
