package com.example.ex1_menu.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class SandWichController {
    @GetMapping("/sandwich")
    public String showCheck() {
        return "index";
    }

    @PostMapping("/sandwich")
    public ModelAndView save(String condiment) {
        ModelAndView modelAndView = new ModelAndView("check", "condiment", condiment);
        return modelAndView;
    }

}
