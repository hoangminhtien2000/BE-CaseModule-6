package com.becasemodule6.services.singerSong;

import com.becasemodule6.models.SingerSong;
import com.becasemodule6.repositories.SingerSongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerSongImpl implements ISingerSongService {
    @Autowired
    SingerSongRepo singerSongRepo;

    @Override
    public List<SingerSong> findAll() {
        return (List<SingerSong>) singerSongRepo.findAll();
    }

    @Override
    public void save(SingerSong singerSong) {
        singerSongRepo.save(singerSong);
    }

    @Override
    public void delete(Long id) {
        singerSongRepo.deleteById(id);
    }

    @Override
    public SingerSong findById(Long id) {
        return singerSongRepo.findById(id).get();
    }

    @Override
    public List<SingerSong> findSingerSongBySong_id(Long song_id) {
        return singerSongRepo.findSingerSongBySong_id(song_id);
    }
}
