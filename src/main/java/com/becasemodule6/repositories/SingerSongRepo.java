package com.becasemodule6.repositories;

import com.becasemodule6.models.SingerSong;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SingerSongRepo extends PagingAndSortingRepository<SingerSong, Long> {
}
