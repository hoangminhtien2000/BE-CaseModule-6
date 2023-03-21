package com.becasemodule6.repositories;

import com.becasemodule6.models.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepo extends PagingAndSortingRepository<Song, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM song WHERE account_id = :account_id")
    List<Song> findSaveSong(int account_id);


    @Query(nativeQuery = true, value = "SELECT * FROM song WHERE actives = :actives")
    List<Song> showActiveSong(int actives);

    @Query(nativeQuery = true, value = "SELECT * FROM song WHERE song_name = :song_name")
    Song findSongBySongName(String song_name);

    //    Hoành thêm
    @Query(value = "SELECT * FROM blog_music.song JOIN blog_music.singer_song on blog_music.song.id=blog_music.singer_song.song_id\n" +
            "JOIN blog_music.singer on blog_music.singer.id=blog_music.singer_song.singer_id WHERE blog_music.singer.id=:id", nativeQuery = true)
    List<Song> findSongBySinger(@Param("id") int id);


    @Query(value = "SELECT * FROM blog_music.song \n" +
            " ORDER BY blog_music.song.listens DESC LIMIT 10", nativeQuery = true)
    List<Song> findTop10Song();

    @Query(value = "SELECT * FROM blog_music.song \n" +
            " ORDER BY blog_music.song.listens DESC LIMIT 5", nativeQuery = true)
    List<Song> findTop5Song();


// Hoành thêm

    @Query(value = "SELECT * FROM blog_music.song \n" +
            " ORDER BY blog_music.song.likes DESC LIMIT 10", nativeQuery = true)
    List<Song> findTopLikeSong();


//    Hùng thêm

    @Query(nativeQuery = true, value = "select * from blog_music.song order by blog_music.song.id desc;")
    List<Song> getAllOrderBySong_Id();


}
