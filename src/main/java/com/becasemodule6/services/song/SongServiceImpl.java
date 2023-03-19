package com.becasemodule6.services.song;

import com.becasemodule6.models.SingerSong;
import com.becasemodule6.models.Song;
import com.becasemodule6.repositories.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    SongRepo songRepo;

    @Override
    public List<Song> findAll() {
        return (List<Song>) songRepo.findAll();
    }

    @Override
    public void save(Song song) {
        songRepo.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepo.deleteById(id);
    }

    @Override
    public Song findById(Long id) {
        return songRepo.findById(id).get();
    }

    @Override
    public List<Song> findSaveSong(int account_id) {
        return songRepo.findSaveSong(account_id);
    }



//    Hoành thêm
    public List<Song> findSongBySinger(int id){
       return  songRepo.findSongBySinger(id);
    }

    //    Hoành thêm
    public List<Song> findTop10Song(){
        return  songRepo.findTop10Song();
    }

    //    Hoành thêm
    public List<Song> findTopLikeSong(){
        return  songRepo.findTopLikeSong();
    }

//    Hùng thêm

    public List<Song> getAllOrderBySong_Id() {
        return songRepo.getAllOrderBySong_Id();
    }




}
