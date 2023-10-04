package codegym.vn.controller;

import codegym.vn.entity.Nasa;
import codegym.vn.repository.NasaRepository;
import codegym.vn.repository.NasaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nasa")
public class NasaController {
    @Autowired
    private NasaRepository nasaRepository;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("nasaCreate", new Nasa());
        model.addAttribute("nasa", nasaRepository.findAll());
        model.addAttribute("nasa1", nasaRepository.findAll());
        return "nasa_img/list";
    }

    @PostMapping("/list")
    public String doCreate (@ModelAttribute("nasa") Nasa nasa){
        nasaRepository.create(nasa);
        return "redirect:/nasa/list";
    }
}
