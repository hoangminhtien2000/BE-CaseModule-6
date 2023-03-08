package com.becasemodule6.controllers;

import com.becasemodule6.models.Singer;
import com.becasemodule6.models.Song;
import com.becasemodule6.services.singer.ISingerService;
import com.becasemodule6.services.song.ISongService;
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
    private ISingerService iSingerService;
    @Autowired
    private ISongService iSongService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Song>> findAllSong() {
        return new ResponseEntity<>(iSongService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> findById(@PathVariable Long id) {
        return new ResponseEntity<>(iSongService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Song song) {
        iSongService.save(song);
        return new ResponseEntity<>(HttpStatus.OK);
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

// ---------------------------------   Singer   --------------------------------------------------
@GetMapping("/singer")
public ResponseEntity<List<Singer>> findAllSinger(){
    return new ResponseEntity<>(iSingerService.findAll(), HttpStatus.OK) ;
}

    @GetMapping("/singer/{id}")
    public ResponseEntity<Singer> findByIdSinger(@PathVariable Long id) {
        return new ResponseEntity<>(iSingerService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/singer")
    public ResponseEntity<?> saveSinger(@RequestBody Singer singer) {
        iSingerService.save(singer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/singer")
    public ResponseEntity<?> editSinger(@RequestBody Singer singer) {
        iSingerService.save(singer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/singer/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        iSingerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
