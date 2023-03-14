package com.becasemodule6.controllers;


import com.becasemodule6.models.Account;
import com.becasemodule6.models.Playlist;
import com.becasemodule6.models.Song;
import com.becasemodule6.models.dto.AccountToken;
import com.becasemodule6.models.dto.PlaylistSongId;
import com.becasemodule6.models.dto.PlaylistToken;
import com.becasemodule6.services.account.AccountServiceImpl;
import com.becasemodule6.services.playlist.PlaylistServiceImpl;
import com.becasemodule6.services.song.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    PlaylistServiceImpl playlistService;

    @Autowired
    AccountServiceImpl accountService;

    @Autowired
    SongServiceImpl songService;

    List<Song> songs = new ArrayList<>();
    List<Playlist> playlists = new ArrayList<>();

    @GetMapping("/delete/{id}")
    public void deletePlaylist(@PathVariable long id) {
        playlistService.delete(id);
    }

    @GetMapping("/find/{id}")
    public Playlist findPlaylistById(@PathVariable long id) {
        return playlistService.findById(id);
    }

    @GetMapping("/show")
    public List<Playlist> getAll() {
        return playlistService.findAll();
    }

    @PostMapping("/create")
    public AccountToken savePlaylist(@RequestBody PlaylistToken playlistToken) {
        long idAccount = playlistToken.getAccount_id();
        String namePlaylist = playlistToken.getName();
        String token = playlistToken.getToken();

        Playlist newPlaylist = new Playlist(namePlaylist, idAccount);
        playlistService.save(newPlaylist);
        Playlist playlist1 = playlistService.findPlaylistByNameAndIdAccount(namePlaylist, idAccount);
        Account account = accountService.findById(idAccount);
        playlists = account.getPlaylist();
        playlists.add(playlist1);
        account.setPlaylist(playlists);
        accountService.save(account);
        return new AccountToken(idAccount, account.getUsername(), account.getFull_name(), account.getGender(), account.getGmail(), account.getAddress(), account.getPhone_number(), account.getAvatar(), account.getRoles(), account.getPlaylist(), token);
    }

    @PostMapping("/add/song")
    public AccountToken addSongToPlaylist(@RequestBody PlaylistSongId playlistSongId) {
        long id_playlist = playlistSongId.getPlaylist_id();
        long id_songId = playlistSongId.getSong_id();
        long id_account = playlistSongId.getAccount_id();
        String token = playlistSongId.getToken();

        Account account = accountService.findById(id_account);
        Playlist playlist = playlistService.findById(id_playlist);
        Song song = songService.findById(id_songId);
        songs = playlist.getSongs();
        songs.add(song);
        playlist.setSongs(songs);
        playlistService.save(playlist);
        return new AccountToken(id_account, account.getUsername(), account.getFull_name(), account.getGender(), account.getGmail(), account.getAddress(), account.getPhone_number(), account.getAvatar(), account.getRoles(), account.getPlaylist(), token);
    }
}
