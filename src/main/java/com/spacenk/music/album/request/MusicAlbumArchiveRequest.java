package com.spacenk.music.album.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MusicAlbumArchiveRequest {

    @NotNull(message = "Please provide a title")
    private String title;

    @NotNull(message = "Please provide a band")
    private String band;

    @NotNull(message = "Please provide a coverArtwork")
    private String coverArtwork;

    @NotNull(message = "Please provide a track")
    private String track;

}