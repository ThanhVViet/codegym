package com.example.upload_music.service;


import com.example.upload_music.model.Song;
import com.example.upload_music.util.CommonUtil;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SongService {
    private final List<Song> songs = new ArrayList<>();

    public ResponseEntity<Resource> downloadFile(ServletContext servletContext, String code) {
        Resource resource = null;
        String path = "";
        String id = code.substring(0, code.length() - 2);
        int idDecode = Integer.parseInt(CommonUtil.decode64(id));
        Optional<Song> opSong = songs.stream().filter(e -> e.getId() == idDecode).findFirst();

        String fileName = "";
        if (opSong.isPresent()) {
            path = opSong.get().getPath();
            resource = loadFileAsResource(path);
            fileName = opSong.get().getName();
        }

        return ResponseEntity.ok()
                .contentType(CommonUtil.getMediaTypeForFileName(servletContext,path))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    public void create(ServletContext servletContext, Song song) {
        int lastId = 0;
        if (songs.size() > 0) {
            lastId = songs.get(songs.size() - 1).getId();
        }
        song.setId(lastId + 1);

        MultipartFile multipartFile = song.getFile();
        String idEncode = CommonUtil.encode64(String.valueOf(song.getId()));
        try {
            String path = getAbsolutePath("img") + File.separator + CommonUtil.encodeMD5(multipartFile.getName() + LocalDateTime.now());
            FileCopyUtils.copy(multipartFile.getBytes(), new File(path));
            String url = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
            URI uri = new URI(url);
            song.setLink(String.format("%s://%s:%s/img/%s", uri.getScheme(), uri.getHost(), uri.getPort(), idEncode + "QG"));
            song.setPath(path);
            MediaType mediaType = CommonUtil.getMediaTypeForFileName(servletContext,multipartFile.getOriginalFilename());
            song.setFileType(mediaType.getType());
            songs.add(song);
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    public List<Song> getAll() {
        return songs;
    }

    public Resource loadFileAsResource(String filePath) {
        Resource resource = null;
        try {
            resource = new UrlResource(Paths.get(filePath).toUri());
            if (resource.exists()) {
                return resource;
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }

        return resource;
    }

    private String getAbsolutePath(String folder) {
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + folder);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        return dir.getAbsolutePath();
    }
}
