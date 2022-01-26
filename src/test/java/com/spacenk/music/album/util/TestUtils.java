package com.spacenk.music.album.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spacenk.music.album.request.MusicAlbumArchiveRequest;

public class TestUtils {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static MusicAlbumArchiveRequest getValidMusicAlbumDetails() {
        MusicAlbumArchiveRequest musicAlbumArchiveRequest = new MusicAlbumArchiveRequest();
        musicAlbumArchiveRequest.setTitle("agatha");
        musicAlbumArchiveRequest.setBand("episode");
        musicAlbumArchiveRequest.setTrack("shows");
        musicAlbumArchiveRequest.setCoverArtwork("art");
        return musicAlbumArchiveRequest;
    }
}
