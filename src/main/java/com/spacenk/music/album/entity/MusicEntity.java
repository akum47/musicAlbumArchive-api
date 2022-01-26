package com.spacenk.music.album.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "music_album")
public class MusicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BAND")
    private String band;

    @Column(name = "COVER_ARTWORK")
    private String coverArtwork;

    @Column(name = "TRACKS")
    private String tracks;
}
