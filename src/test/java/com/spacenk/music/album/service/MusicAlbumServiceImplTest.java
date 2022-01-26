package com.spacenk.music.album.service;

import com.spacenk.music.album.entity.MusicEntity;
import com.spacenk.music.album.exception.MusicAlbumAlreadyExistException;
import com.spacenk.music.album.repository.MusicAlbumArchiveRepository;
import com.spacenk.music.album.request.MusicAlbumArchiveRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MusicAlbumServiceImplTest {

    @Autowired
    private MusicAlbumService musicAlbumService;

    @MockBean
    private MusicAlbumArchiveRepository musicAlbumArchiveRepository;

    @Test
    public void checkIfMusicAlbumDoesNotExist_createOneSuccessfully() {
        // this mock musicAlbumArchiveRepository and return empty response
        when(musicAlbumArchiveRepository.findByTitle(Mockito.anyString())).
                thenReturn(Optional.empty());
        musicAlbumService.add(getMusicAlbumArchiveRequest());
    }

    @Test
    public void checkIfMusicAlbumExist_throwError() {
        when(musicAlbumArchiveRepository.findByTitle(Mockito.anyString())).
                thenReturn(Optional.of(getMusicAlbumDetails()));

        assertThrows(MusicAlbumAlreadyExistException.class,
                () -> musicAlbumService.add(getMusicAlbumArchiveRequest()));
    }

    @Test
    public void getAllMusicAlbum() {
        List<MusicEntity> musicAlbumList = Arrays.asList(getMusicAlbumDetails());
        when(musicAlbumArchiveRepository.findAll()).
                thenReturn(musicAlbumList);

        assertEquals(musicAlbumList, musicAlbumService.getAll());
    }

    private MusicAlbumArchiveRequest getMusicAlbumArchiveRequest() {
        MusicAlbumArchiveRequest musicAlbumArchiveRequest = new MusicAlbumArchiveRequest();
        musicAlbumArchiveRequest.setTitle("asdf");
        musicAlbumArchiveRequest.setCoverArtwork("rty");
        musicAlbumArchiveRequest.setTrack("vbnm");
        musicAlbumArchiveRequest.setBand("tyui");
        return musicAlbumArchiveRequest;
    }

    private MusicEntity getMusicAlbumDetails() {
        return MusicEntity.builder().
                coverArtwork("uio").
                band("qwsd").
                title("cfr").
                tracks("mht").
                build();
    }
}
