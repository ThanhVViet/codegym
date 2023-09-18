package com.example.exercise_2.controller;

import com.example.exercise_2.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class DictionaryServlet {
    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/dictionary", method = RequestMethod.GET)
    public String showDic() {
        return "dictionary";
    }

    @PostMapping("dictionary")
    public String find(@RequestParam String word, Model medel) {
        String result = dictionaryService.search(word);
        if (result != null) {
            medel.addAttribute("word", result);
        } else {
            medel.addAttribute("word", "not found");
        }
        return "dictionary";
    }

//    @GetMapping("search")
//    public ModelAndView result(@RequestParam String search){
//        String result= dictionaryService.search(search);
//        return new ModelAndView("result", "result", result == null? "Not found": result);
//    }
}
