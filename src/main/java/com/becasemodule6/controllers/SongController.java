package com.becasemodule6.controllers;

import com.becasemodule6.models.Account;
import com.becasemodule6.models.Singer;
import com.becasemodule6.models.SingerSong;
import com.becasemodule6.models.Song;
import com.becasemodule6.services.singer.ISingerService;
import com.becasemodule6.services.singerSong.ISingerSongService;
import com.becasemodule6.services.song.ISongService;
import com.becasemodule6.services.song.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @Autowired
    private SongServiceImpl songServiceIml;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Song>> findAllSong() {
        return new ResponseEntity<>(iSongService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> findById(@PathVariable Long id) {
        return new ResponseEntity<>(iSongService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Song> save(@RequestBody Song song) {
        iSongService.save(song);
        return new ResponseEntity<>(song,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestBody Song song) {
        iSongService.save(song);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        iSongService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Hoành thêm
    @GetMapping("/findSongBySinger/{id}")
    public List<Song> findSongBySinger(@PathVariable int id) {
        return songServiceIml.findSongBySinger(id);

    }
    // Hoành thêm
    @PostMapping("/save/newListens")
    public Song saveNewListens(@RequestBody Song song) {
        Song song1 = songServiceIml.findById(song.getId());
        song1.setListens(song.getListens());
        songServiceIml.save(song1);
        return song1;
    }








}
