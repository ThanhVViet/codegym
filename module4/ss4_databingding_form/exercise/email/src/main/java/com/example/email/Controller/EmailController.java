package com.example.email.Controller;

import com.example.email.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmailController {

    private static Email email = new Email();

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView update() {
        ModelAndView modelAndView = new ModelAndView("email", "email", email);
        return modelAndView;
    }

    @PostMapping("/save")
    public String update_info(Email e) {
        email = e;
        return "index";
    }
}
