package com.example.music.controller;

import com.example.music.model.Music;
import com.example.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/music")
public class MusicController {
    private IMusicService IMusicService;

    @Autowired
    public MusicController(IMusicService IMusicService) {
        this.IMusicService = IMusicService;
    }

    @GetMapping("/home")
    public ModelAndView showAll() {
        List<Music> music = IMusicService.getAllSong();
        ModelAndView modelAndView = new ModelAndView("index", "res", music);
        return modelAndView;
    }

    @GetMapping("/form")
    public String viewForm(Model model) {
        model.addAttribute("song", new Music());
        return "form";
    }

    @PostMapping("/save")
    public String add(Music song) {
        IMusicService.addSong(song);
        return "redirect:/music/home";
    }

    @GetMapping("/file/{code}")
    public ResponseEntity<Resource> playMp3(HttpServletRequest request, @PathVariable String code) {
        return IMusicService.downloadFile(request.getServletContext(), code);
    }
}
