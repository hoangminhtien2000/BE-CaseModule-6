package com.becasemodule6.controllers;

import com.becasemodule6.models.Singer;
import com.becasemodule6.models.SingerSong;
import com.becasemodule6.models.Song;
import com.becasemodule6.models.dto.SingerSongId;
import com.becasemodule6.services.singer.ISingerService;
import com.becasemodule6.services.singerSong.ISingerSongService;
import com.becasemodule6.services.singerSong.SingerSongImpl;
import com.becasemodule6.services.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/singerSong")
public class SingerSongController {
    @Autowired
    private ISingerService iSingerService;
    @Autowired
    private ISongService iSongService;

    @Autowired
    private ISingerSongService iSingerSongService;
    @Autowired
    SingerSongImpl singerSongService;

    @GetMapping("/findSong/singer/{singer_id}")
    public List<Song> findSongBySinger(@PathVariable Long singer_id) {
        Singer singer = iSingerService.findById(singer_id);
        return singerSongService.findSongBySinger(singer);
    }

    @GetMapping()
    public ResponseEntity<List<SingerSong>> findAllSingerSong(){
        return new ResponseEntity<>(iSingerSongService.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/singer/{song_id}")
    public ResponseEntity<List<SingerSong>> findSingerSongBySong_id(@PathVariable Long song_id){
        return new ResponseEntity<>(iSingerSongService.findSingerSongBySong_id(song_id), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SingerSong> findByIdSingerSong(@PathVariable Long id) {
        return new ResponseEntity<>(iSingerSongService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> saveSingerSong(@RequestBody SingerSongId singerSongId) {
        SingerSong singerSong1 = new SingerSong();
        singerSong1.setSinger(iSingerService.findById(singerSongId.getSinger_id()));
        singerSong1.setSong(iSongService.findById(singerSongId.getSong_id()));
        iSingerSongService.save(singerSong1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> editSingerSong(@RequestBody SingerSong singerSong) {
        iSingerSongService.save(singerSong);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSingerSong(@PathVariable Long id) {
        iSingerSongService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
