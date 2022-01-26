package com.spacenk.music.album.repository;

import com.spacenk.music.album.entity.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicAlbumArchiveRepository extends JpaRepository<MusicEntity, Long> {

    Optional<MusicEntity> findByTitle(String title);
}
