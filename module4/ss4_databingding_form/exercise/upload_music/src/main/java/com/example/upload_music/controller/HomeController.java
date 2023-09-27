package com.example.upload_music.controller;


import com.example.upload_music.model.Song;
import com.example.upload_music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.ServletContext;

@Controller
public class HomeController {
    private final SongService songService;
    @Autowired
    private ServletContext servletContext;

    public HomeController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index", "res", songService.getAll());
    }

    @GetMapping("add")
    public String create() {
        return "create";
    }

    @PostMapping
    public String save(@ModelAttribute Song song) {
        songService.create(servletContext, song);

        return "redirect:/";
    }

    @GetMapping("img/{code}")
    public ResponseEntity<Resource> viewImage(@PathVariable String code) {
        return songService.downloadFile(this.servletContext, code);
    }
}
