package vn.codegym.controller;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.dto.CartDto;
import vn.codegym.dto.ProductDto;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping(value = "/shop")
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }
    @Autowired
    ProductService productService;

    @GetMapping
    public String showListPage(@SessionAttribute(value = "cart",required = false) CartDto cartDto,
                                     @CookieValue(value = "idProduct",
                                                  required = false,
                                                  defaultValue = "-1") Long idProduct,
                                     Model model) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct));
        }
        if (cartDto!=null){
            model.addAttribute("cart", cartDto);
        }
        model.addAttribute("productList", productService.findAll());
        return "product/list";
    }


    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable long id, HttpServletResponse response,Model model) {

        /*Tạo cookie*/
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60); //thoi gian ton tai trong 1 ngay
//        cookie.setMaxAge(0); // huy cookie
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product",productService.findById(id));
        return "product/detail";
    }

// thêm mới vào giỏ hàng
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cart) {
        Product productOption = productService.findById(id);
        if (productOption!=null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOption, productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}