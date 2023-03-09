package com.becasemodule6.controllers;

import com.becasemodule6.models.PlayList;
import com.becasemodule6.models.Singer;
import com.becasemodule6.repositories.PlayListRepo;
import com.becasemodule6.services.playList.IPlayListService;
import com.becasemodule6.services.singer.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlist")
public class PlayListController {
    @Autowired
    private IPlayListService iPlayListService;
    @GetMapping()
    public ResponseEntity<List<PlayList>> findAllPlayList(){
        return new ResponseEntity<>(iPlayListService.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayList> findByIdPlayList(@PathVariable Long id) {
        return new ResponseEntity<>(iPlayListService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> savePlayList(@RequestBody PlayList playList) {
        iPlayListService.save(playList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> editPlayList(@RequestBody PlayList playList) {
        iPlayListService.save(playList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayList(@PathVariable Long id) {
        iPlayListService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
