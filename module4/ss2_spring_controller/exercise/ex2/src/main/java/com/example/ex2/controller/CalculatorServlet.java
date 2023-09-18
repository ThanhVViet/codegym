package com.example.ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalculatorServlet {


    @GetMapping("/calculator")
    public String showCalculator() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam Double n1, @RequestParam Double n2,
                             @RequestParam("operator") String operator, Model model) {
        String result = "";
        switch (operator) {
            case "+":
                result = String.valueOf(n1 + n2);
                break;
            case "-":
                result = String.valueOf(n1 - n2);
                break;
            case "*":
                result = String.valueOf(n1 * n2);
                break;
            case "/":
                result = n2 == 0 ? "Cannot be divided by 0": String.valueOf(n1/n2);

        }

        model.addAttribute("result", result);
        return "index";
    }


}
