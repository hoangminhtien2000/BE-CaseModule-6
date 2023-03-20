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

    @GetMapping("showActive/{id}")
    public List<Playlist> findAllPlaylistActive(@PathVariable int id) {
        return playlistService.findPlaylistActive(id);
    }

    @GetMapping("/delete/{id}")
    public void deletePlaylist(@PathVariable long id) {
        playlistService.delete(id);
    }

    @GetMapping("/find/{id}")
    public Playlist findPlaylistById(@PathVariable Long id) {
        return playlistService.findById(id);
    }

    @GetMapping("/show/{id}")
    public List<Playlist> getAll(@PathVariable long id) {
        return playlistService.getAll(id);
    }

    @PostMapping("/create")
    public void savePlaylist(@RequestBody PlaylistToken playlistToken) {
        long idAccount = playlistToken.getAccount_id();
        String namePlaylist = playlistToken.getName();
        int active = playlistToken.getActive();
        String avatarPlaylist = playlistToken.getAvatarPlaylist();

        Playlist newPlaylist = new Playlist(avatarPlaylist, namePlaylist, idAccount, active);
        playlistService.save(newPlaylist);
        Playlist playlist1 = playlistService.findPlaylistByNameAndIdAccount(namePlaylist, idAccount);
        Account account = accountService.findById(idAccount);
        playlists = account.getPlaylist();
        playlists.add(playlist1);
        account.setPlaylist(playlists);
        accountService.save(account);
    }

    @PostMapping("/save")
    public void saveEditPlaylist(@RequestBody PlaylistToken playlistToken) {
        long playlist_id = playlistToken.getId();
        Playlist playlist = playlistService.findById(playlist_id);

        playlist.setActive(playlistToken.getActive());
        playlist.setAvatarPlaylist(playlistToken.getAvatarPlaylist());
        playlist.setName(playlistToken.getName());
        playlist.setActive(playlist.getActive());
        playlistService.save(playlist);
    }

    @PostMapping("/add/song")
    public void addSongToPlaylist(@RequestBody PlaylistSongId playlistSongId) {
        long playlist_id = playlistSongId.getPlaylist_id();
        long song_id = playlistSongId.getSong_id();

        Playlist playlist = playlistService.findById(playlist_id);
        Song song = songService.findById(song_id);
        songs = playlist.getSongs();
        songs.add(song);
        playlist.setSongs(songs);
        playlistService.save(playlist);
    }

    @PostMapping("/checkSong")
    public boolean checkSongInPlaylist(@RequestBody PlaylistSongId playlistSongId) {
        long playlist_id = playlistSongId.getPlaylist_id();
        long song_id = playlistSongId.getSong_id();

        Playlist playlist = findPlaylistById(playlist_id);
        songs = playlist.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getId() == song_id) {
                return false;
            }
        }
        return true;
    }

    @PostMapping("/remove/song")
    public void removeSongInPlaylist(@RequestBody PlaylistSongId playlistSongId) {
        long playlist_id = playlistSongId.getPlaylist_id();
        long song_id = playlistSongId.getSong_id();

        Playlist playlist = findPlaylistById(playlist_id);
        songs = playlist.getSongs();
        Song song = songService.findById(song_id);
        songs.remove(song);
        playlist.setSongs(songs);
        playlistService.save(playlist);
    }
}
