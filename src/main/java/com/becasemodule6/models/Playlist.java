package com.becasemodule6.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "avatar_playlist", columnDefinition = "LONGTEXT")
    private String avatarPlaylist;
    private String name;
    private long account_id;

    private int active;

    @ManyToMany
    private List<Song> songs;

    public Playlist(String avatarPlaylist, String name, long account_id, int active) {
        this.avatarPlaylist = avatarPlaylist;
        this.name = name;
        this.account_id = account_id;
        this.active = active;
    }

    public Playlist() {
    }
}
