package com.becasemodule6.repositories;

import com.becasemodule6.models.Song;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongRepo extends PagingAndSortingRepository<Song, Long> {
}
