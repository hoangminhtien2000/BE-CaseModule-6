package com.becasemodule6.services.song;

import com.becasemodule6.models.SingerSong;
import com.becasemodule6.models.Song;
import com.becasemodule6.services.CrudService;

import java.util.List;

public interface ISongService extends CrudService<Song> {
    List<Song> findSaveSong(int account_id);

    List<Song> showActiveSong(int actives);

    Song findSongBySongName(String song_name);

    List<Song> find4NewSong();

}
