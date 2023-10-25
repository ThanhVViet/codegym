package com.example.music.service;


import com.example.music.model.Song;
import com.example.music.repository.SongRepository;
import com.example.music.util.CommonUtil;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public void save(Song song) {
        int lastId = 0;
        List<Song> songs = songRepository.findAll();
        if (songs.size() > 0) {
            lastId = songs.get(songs.size() - 1).getId();
        }

        MultipartFile multipartFile = song.getFile();
        String idEncode = CommonUtil.encode64(String.valueOf(lastId+1));
        try {
            String path = CommonUtil.getAbsolutePath("file") + File.separator + CommonUtil.encodeMD5(multipartFile.getName() + LocalDateTime.now());
            FileCopyUtils.copy(multipartFile.getBytes(), new File(path));
            song.setLink(idEncode + "QG");
            song.setPath(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        songRepository.save(song);
    }

    public Optional<Song> findById(Long id) {
        return songRepository.getById(id);
    }

    public void delete(Integer id) {
        songRepository.delete(id);
    }

    public ResponseEntity<Resource> downloadFile(ServletContext servletContext, String code) {
        Resource resource = null;
        String path = "";
        String id = code.substring(0, code.length() - 2);
        int idDecode = Integer.parseInt(CommonUtil.decode64(id));
        Optional<Song> opSong = findAll().stream().filter(e -> e.getId() == idDecode).findFirst();

        String fileName = "";
        if (opSong.isPresent()) {
            path = opSong.get().getPath();
            resource = CommonUtil.loadFileAsResource(path);
            fileName = opSong.get().getName();
        }

        return ResponseEntity.ok()
                .contentType(CommonUtil.getMediaTypeForFileName(servletContext,fileName))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }


}
