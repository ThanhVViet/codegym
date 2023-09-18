package com.example.exercise_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CalculatorServlet {
    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String showFormExchange() {
        return "calculator";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String exchange(@RequestParam double usd, Model model) {
        double usd2 = usd * 20000;
        double vnd2 = usd2;
        model.addAttribute("vnd", vnd2);
        return "calculator";
    }
}
