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
    private String avatarPlaylist;
    private String name;
    private long account_id;

    private int active;

    @ManyToMany
    private List<Song> songs;

    public Playlist(String name, long account_id, int active) {
        this.name = name;
        this.account_id = account_id;
        this.active = active;
    }

    public Playlist() {
    }
}
