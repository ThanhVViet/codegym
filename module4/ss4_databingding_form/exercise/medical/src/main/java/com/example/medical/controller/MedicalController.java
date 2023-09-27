package com.example.medical.controller;

import com.example.medical.model.Medical;
import com.example.medical.service.MedicalService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class MedicalController {

    private MedicalService medicalService;

    @Autowired
    public MedicalController(MedicalService medicalService) {
        this.medicalService = medicalService;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        List<Medical> medicalList = medicalService.findAll();
        ModelAndView modelAndView = new ModelAndView("list", "medicalList", medicalList);
        return modelAndView;
    }

    @GetMapping(path = {"/create",})
    public ModelAndView viewCreate(@PathVariable(required = false) Optional<Integer> id, @ModelAttribute("result") Medical medical) {
        if (id.isPresent()) {
            Optional<Medical> medicalOptional = medicalService.findById(id.get());
            if (medicalOptional.isPresent()) {
                medical = medicalOptional.get();
            }

        }
        ModelAndView modelAndView = new ModelAndView("index", "result", medical);
        return modelAndView;
    }

    @GetMapping("/create/{id}")
    public String edit(@PathVariable(required = false) int id, Model model) {
        model.addAttribute("result", medicalService.findById2(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("result") Medical medical) {
        medicalService.update(medical);
        return "redirect:/home";
    }


    @PostMapping
    public String save(Medical medical) {
        medicalService.save(medical);
        return "redirect:/home";
    }
}
