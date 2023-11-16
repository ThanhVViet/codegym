package com.example.cart.controller;

import com.example.cart.dto.CartDTO;
import com.example.cart.dto.ProductDTO;
import com.example.cart.model.Product;
import com.example.cart.service.ICategoryService;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public CartDTO initCart() {
        return new CartDTO();
    }

    private IProductService iProductService;

    private ICategoryService iCategoryService;

    @Autowired
    public ProductController(IProductService iProductService, ICategoryService iCategoryService) {
        this.iProductService = iProductService;
        this.iCategoryService = iCategoryService;
    }

    @GetMapping("")
    public String homePage(@SessionAttribute(value = "cart", required = false) CartDTO cartDTO, Model model) {

        if (cartDTO != null) {
            model.addAttribute("cart", cartDTO);
        }
        model.addAttribute("products", iProductService.findAll());
        return "product/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("product/create", "productDTO", new ProductDTO());
        modelAndView.addObject("categories", iCategoryService.findAll());
        return modelAndView;
    }

    //        String imageUUID;
//        if (!file.isEmpty()) {
//            imageUUID = file.getOriginalFilename();
//            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
//            Files.write(fileNameAndPath, file.getBytes());
//        } else {
//            imageUUID = imgName;
//        }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute("productDTO") ProductDTO productDTO
            , @RequestParam("proImage") MultipartFile file
    ) throws IOException {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(iCategoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDiscount(productDTO.getDiscount());
        product.setDescription(productDTO.getDescription());


        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        product.setImageName(fileName);

        String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/image/productImages/";

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            System.out.println(filePath.toFile().getAbsoluteFile());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException ex) {
            throw new IOException("Could not save !! " + fileName);

        }
        iProductService.save(product);


        return "redirect:/product";
    }

    @GetMapping("/{id}/update")
    public String showUpdateForm(@PathVariable Long id) {

        return "redirect:/product";
    }

    // thêm mới vào giỏ hàng
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDTO cart) {
        Product productOption = iProductService.findById(id);
        if (productOption != null) {
            ProductDTO productDto = new ProductDTO();
            BeanUtils.copyProperties(productOption, productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }


}
