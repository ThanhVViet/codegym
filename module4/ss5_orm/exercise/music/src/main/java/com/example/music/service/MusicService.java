package com.example.music.service;

import com.example.music.repository.IMusicRepository;
import com.example.music.model.Music;
import com.example.music.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MusicService implements IMusicService {

    private final IMusicRepository iMusicRepository;

    @Autowired
    public MusicService(IMusicRepository iMusicRepository) {
        this.iMusicRepository = iMusicRepository;
    }

    @Override
    public List<Music> getAllSong() {
        return iMusicRepository.findAll();
    }

    @Override
    public Music findById(Long id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void addSong(Music music) {
//        int lastId = 0;
//        List<Music> songs = iMusicRepository.findAll();
//        if (songs.size() > 0) {
//            lastId = songs.get(songs.size() - 1).getId();
//        }
//
//        MultipartFile multipartFile = music.getFile();
//        String idEncode = CommonUtil.encode64(String.valueOf(lastId+1));
//        try {
//            String path = CommonUtil.getAbsolutePath("file") + File.separator + CommonUtil.encodeMD5(multipartFile.getName() + LocalDateTime.now());
//            FileCopyUtils.copy(multipartFile.getBytes(), new File(path));
//            music.setLink(idEncode + "QG");
//            music.setPath(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        iMusicRepository.save(music);
    }

    @Override
    public Music updateStudent(Music student) {
        return null;
    }

    @Override
    public void deleteSongById(int id) {
        iMusicRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Resource> downloadFile(ServletContext servletContext, String code) {
        Resource resource = null;
        String path = "";
        String id = code.substring(0, code.length() - 2);
        int idDecode = Integer.parseInt(CommonUtil.decode64(id));
        Optional<Music> opSong = getAllSong().stream().filter(e -> e.getId() == idDecode).findFirst();

        String fileName = "";
        if (opSong.isPresent()) {
            path = opSong.get().getPath();
            resource = CommonUtil.loadFileAsResource(path);
            fileName = opSong.get().getName();
        }

        return ResponseEntity.ok()
                .contentType(CommonUtil.getMediaTypeForFileName(servletContext, fileName))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }
}
