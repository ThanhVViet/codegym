package com.example.music.repository;



import com.example.music.model.Music;

import java.util.List;


public interface IMusicRepository {
    List<Music> findAll();

    Music findById(Long id);

    void save (Music Music);

    Music saveAndFlush(Music Music);
    void deleteById(int id);


}
