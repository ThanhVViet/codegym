package com.example.exam.controller;

import com.example.exam.dto.ContentDTO;
import com.example.exam.model.QuestionContent;
import com.example.exam.model.QuestionType;
import com.example.exam.service.IContent;
import com.example.exam.service.IType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ContentController {
    private IContent iContent;
    private IType iType;

    @Autowired
    public ContentController(IContent iContent, IType iType) {
        this.iContent = iContent;
        this.iType = iType;
    }

    @GetMapping("/home")
    public String showList(@PageableDefault(page = 0, size = 5, sort = "title", direction = Sort.Direction.ASC) Pageable pageable,
                           @RequestParam(defaultValue = "", required = false) String searchName,
                           @RequestParam(defaultValue = "0", required = false) int key,
                           Model model) {

        Page<QuestionContent> contents;
        if (key == 0) {
            contents = iContent.findAll(pageable, searchName);
        } else {
            contents = iContent.getBlogByCat(pageable, key);
        }

        List<QuestionType> categories = iType.findAll();

        model.addAttribute("categories", categories);
        model.addAttribute("key", key);
        model.addAttribute("blogs", contents);
        model.addAttribute("searchName", searchName);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contentDTO", new ContentDTO());
        List<QuestionType> categories = iType.findAll();
        model.addAttribute("categories", categories);
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("contentDTO") ContentDTO contentDTO,
                                BindingResult bindingResult,
                                Model model
    ) {


        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", iType.findAll());
            return "create";
        }
        QuestionContent product = new QuestionContent();
        product.setId(contentDTO.getId());
        product.setTitle(contentDTO.getTitle());
        product.setContent(contentDTO.getContent());
        product.setType(iType.findById(contentDTO.getTypeId()).get());
        product.setDate("11/20/2023");
        product.setStatus(1);

        iContent.add(product);

        return "redirect:/home";
    }

    @PostMapping("/delete")
    public String delete(QuestionContent blog) {
        iContent.deleteBlogById(blog.getId());
        return "redirect:/home";
    }


}
