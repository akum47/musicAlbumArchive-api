package com.spacenk.music.album.controller;

import com.spacenk.music.album.request.MusicAlbumArchiveRequest;
import com.spacenk.music.album.service.MusicAlbumService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.spacenk.music.album.util.TestUtils.asJsonString;
import static com.spacenk.music.album.util.TestUtils.getValidMusicAlbumDetails;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MusicAlbumArchiveController.class)
public class MusicAlbumArchiveControllerTest {

    private static final String MUSIC_ARCHIVE_SERVICE_URL = "/api/musicAlbumsArchive";
    private static final String MUSIC_ARCHIVE_SERVICE_URL_INVALID = "/api/musicAlbumsArchive/Invalid";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MusicAlbumService musicAlbumService;

    @Test
    public void givenValidMusicArchiveURIWithValidBody_whenMockMVC_thenResponseCreated() throws Exception {
        mockMvc.perform(post(MUSIC_ARCHIVE_SERVICE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getValidMusicAlbumDetails())))
                .andExpect(status().isCreated());
        ArgumentCaptor<MusicAlbumArchiveRequest> musicAlbumCaptor = ArgumentCaptor.forClass(MusicAlbumArchiveRequest.class);
        verify(musicAlbumService, times(1)).add(musicAlbumCaptor.capture());
    }

    @Test
    public void givenInvalidMusicArchiveURIWithValidBody_whenMockMVC_thenResponseNotFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post(MUSIC_ARCHIVE_SERVICE_URL_INVALID)
                        .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(getValidMusicAlbumDetails())))
                .andExpect(status().isNotFound())
                .andReturn();
        assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @Test
    public void givenValidMusicArchiveURI_whenMockMVC_thenResponseOK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(MUSIC_ARCHIVE_SERVICE_URL))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }
}