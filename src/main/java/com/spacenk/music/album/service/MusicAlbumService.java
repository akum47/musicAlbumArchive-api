package com.spacenk.music.album.service;

import com.spacenk.music.album.entity.MusicEntity;
import com.spacenk.music.album.request.MusicAlbumArchiveRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MusicAlbumService {

    MusicEntity add(MusicAlbumArchiveRequest musicAlbumArchiveRequest);

    List<MusicEntity> getAll();
}
