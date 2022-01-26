package com.spacenk.music.album.service;

import com.spacenk.music.album.entity.MusicEntity;
import com.spacenk.music.album.exception.MusicAlbumAlreadyExistException;
import com.spacenk.music.album.repository.MusicAlbumArchiveRepository;
import com.spacenk.music.album.request.MusicAlbumArchiveRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MusicAlbumServiceImpl implements MusicAlbumService {

    @Resource
    private MusicAlbumArchiveRepository musicAlbumArchiveRepository;

    @Override
    public MusicEntity add(MusicAlbumArchiveRequest musicAlbumArchiveRequest) {

        String title = musicAlbumArchiveRequest.getTitle();

        if (musicAlbumArchiveRepository.findByTitle(title).isPresent())
            throw new MusicAlbumAlreadyExistException(title);

        return musicAlbumArchiveRepository.save(getMusicAlbumEntity(musicAlbumArchiveRequest));
    }

    @Override
    public List<MusicEntity> getAll() {
        return musicAlbumArchiveRepository.findAll();
    }

    private MusicEntity getMusicAlbumEntity(MusicAlbumArchiveRequest musicAlbumArchiveRequest) {
        return MusicEntity.builder()
                .title(musicAlbumArchiveRequest.getTitle())
                .band(musicAlbumArchiveRequest.getBand())
                .coverArtwork(musicAlbumArchiveRequest.getCoverArtwork())
                .tracks(musicAlbumArchiveRequest.getTrack()).build();
    }
}