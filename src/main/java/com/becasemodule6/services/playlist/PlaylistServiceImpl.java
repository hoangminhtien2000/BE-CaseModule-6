package com.becasemodule6.services.playlist;

import com.becasemodule6.models.Playlist;
import com.becasemodule6.repositories.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements IPlaylistService {

    @Autowired
    PlaylistRepo playlistRepo;

    public List<Playlist> findPlaylistActive(int active) {
        return playlistRepo.findAllByActive(active);
    }

    @Override
    public List<Playlist> findAll() {
        return (List<Playlist>) playlistRepo.findAll();
    }

    @Override
    public void save(Playlist playlist) {
        playlistRepo.save(playlist);
    }

    @Override
    public void delete(Long id) {
        playlistRepo.deleteById(id);
    }

    @Override
    public Playlist findById(Long id) {
        return playlistRepo.findById(id).get();
    }

    public List<Playlist> getAll(long id) {
        return playlistRepo.findAllByAccountId(id);
    }

    public Playlist findPlaylistByNameAndIdAccount(String name, long id) {
        return playlistRepo.findPlaylistByNameAndIdAccount(name, id);
    }
}
