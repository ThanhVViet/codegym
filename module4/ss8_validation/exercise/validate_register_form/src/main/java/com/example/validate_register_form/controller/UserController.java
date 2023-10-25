package com.example.validate_register_form.controller;

import com.example.validate_register_form.model.User;
import com.example.validate_register_form.service.UserService;
import com.example.validate_register_form.web.RegisterUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/register")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showRegisterForm")
    public String showRegisterForm(Model model) {
        RegisterUser ru = new RegisterUser();
        model.addAttribute("registerUser", ru);
        return "index";
    }

    @InitBinder
    public void initBinder(WebDataBinder data) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("registerUser") RegisterUser registerUser,
                          BindingResult result,
                          HttpSession httpSession
    ) {


        // form validation
        if (result.hasErrors()) {
            return "index";
        }

        // Nếu chưa ton tai thi luu

        User user = new User();
        user.setAge(registerUser.getAge());
        user.setFirstName(registerUser.getFirstName());
        user.setLastName(registerUser.getLastName());
        user.setEmail(registerUser.getEmail());
        user.setPhone(registerUser.getPhone());


        userService.save(user);

        // thông báo thành công
        httpSession.setAttribute("user", user);

        return "result";
    }


}
