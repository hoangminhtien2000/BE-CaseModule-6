package com.becasemodule6.repositories;

import com.becasemodule6.models.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SongRepo extends PagingAndSortingRepository<Song, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM song WHERE account_id = :account_id")
    List<Song> findSaveSong(int account_id);
    @Query(nativeQuery = true, value = "select * from blog_music.song order by blog_music.song.id asc limit 10;")
    List<Song> findNewSong();

   @Query(nativeQuery = true, value = "select * from blog_music.song where (blog_music.song.actives = ?1) order by blog_music.song.id desc;")
    List<Song> getAllOrderBySong_Id();
}
