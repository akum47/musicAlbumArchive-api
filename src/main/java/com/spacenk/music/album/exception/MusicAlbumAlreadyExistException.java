package com.spacenk.music.album.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class MusicAlbumAlreadyExistException extends RuntimeException {
    public MusicAlbumAlreadyExistException(String title) {
        super("Music Album Already Exist: " + title);
    }
}
