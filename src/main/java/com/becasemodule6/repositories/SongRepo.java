package com.becasemodule6.repositories;

import com.becasemodule6.models.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SongRepo extends PagingAndSortingRepository<Song, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM song WHERE account_id = :account_id")
    List<Song> findSaveSong(int account_id);
}
