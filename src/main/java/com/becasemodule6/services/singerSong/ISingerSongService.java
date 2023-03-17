package com.becasemodule6.services.singerSong;

import com.becasemodule6.models.SingerSong;
import com.becasemodule6.services.CrudService;

import java.util.List;

public interface ISingerSongService extends CrudService<SingerSong> {
    List<SingerSong> findSingerSongBySong_id(Long song_id);
}
