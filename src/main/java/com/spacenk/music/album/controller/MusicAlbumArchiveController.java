package com.spacenk.music.album.controller;

import com.spacenk.music.album.entity.MusicEntity;
import com.spacenk.music.album.request.MusicAlbumArchiveRequest;
import com.spacenk.music.album.service.MusicAlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MusicAlbumArchiveController {

    @Autowired
    private MusicAlbumService musicAlbumService;

    @PostMapping("/musicAlbumsArchive")
    public ResponseEntity addMusicAlbum(@Valid @RequestBody MusicAlbumArchiveRequest musicAlbumArchiveRequest){
        return new ResponseEntity<>(musicAlbumService.add(musicAlbumArchiveRequest), HttpStatus.CREATED);
    }

    @GetMapping ("/musicAlbumsArchive")
    public ResponseEntity<List<MusicEntity>> getAllMusicAlbum(){
        return new ResponseEntity<List<MusicEntity>>(musicAlbumService.getAll(), HttpStatus.OK);
    }

}
