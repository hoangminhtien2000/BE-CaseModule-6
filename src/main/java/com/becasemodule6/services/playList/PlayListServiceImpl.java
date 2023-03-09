package com.becasemodule6.services.playList;

import com.becasemodule6.models.PlayList;
import com.becasemodule6.repositories.PlayListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListServiceImpl implements IPlayListService {
    @Autowired
    PlayListRepo playListRepo;

    @Override
    public List<PlayList> findAll() {
        return (List<PlayList>) playListRepo.findAll();
    }

    @Override
    public void save(PlayList playList) {

        playListRepo.save(playList);
    }

    @Override
    public void delete(Long id) {
        playListRepo.deleteById(id);
    }

    @Override
    public PlayList findById(Long id) {
        return playListRepo.findById(id).get();
    }
}
