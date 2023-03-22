package com.becasemodule6.repositories;

import com.becasemodule6.models.Account;
import com.becasemodule6.models.Singer;
import com.becasemodule6.models.SingerSong;
import com.becasemodule6.models.Song;
import com.becasemodule6.models.dto.SingerSongId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SingerSongRepo extends PagingAndSortingRepository<SingerSong, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM singer_song WHERE song_id = :song_id")
    List<SingerSong> findSingerSongBySong_id(Long song_id);

    @Query("SELECT ss.song FROM SingerSong ss WHERE ss.singer = :singer")
    List<Song> findSongBySinger(Singer singer);
}
