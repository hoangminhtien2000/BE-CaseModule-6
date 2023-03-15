package com.becasemodule6.repositories;

import com.becasemodule6.models.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepo extends PagingAndSortingRepository<Song, Long> {
    @Query(value = "SELECT * FROM blog_music.song JOIN blog_music.singer_song on blog_music.song.id=blog_music.singer_song.song_id\n" +
            "JOIN blog_music.singer on blog_music.singer.id=blog_music.singer_song.singer_id WHERE blog_music.singer.id=:id", nativeQuery = true)
    List<Song> findSongBySinger(@Param("id") int id);

}
