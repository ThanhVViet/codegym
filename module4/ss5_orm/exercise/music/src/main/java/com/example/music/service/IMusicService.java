package com.example.music.service;

import com.example.music.model.Music;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletContext;
import java.util.List;

public interface IMusicService {
    List<Music> getAllSong();
    Music findById(Long id);
    void addSong(Music song);

    Music updateStudent(Music song);
    void deleteSongById(int id);

    ResponseEntity<Resource> downloadFile(ServletContext servletContext, String code);
}
