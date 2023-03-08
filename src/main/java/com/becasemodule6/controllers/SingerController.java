package com.becasemodule6.controllers;

import com.becasemodule6.models.Singer;
import com.becasemodule6.services.singer.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private ISingerService iSingerService;
    @GetMapping()
    public ResponseEntity<List<Singer>> findAllSinger(){
        return new ResponseEntity<>(iSingerService.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Singer> findByIdSinger(@PathVariable Long id) {
        return new ResponseEntity<>(iSingerService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> saveSinger(@RequestBody Singer singer) {
        iSingerService.save(singer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> editSinger(@RequestBody Singer singer) {
        iSingerService.save(singer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        iSingerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
