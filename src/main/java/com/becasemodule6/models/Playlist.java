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
    private String name;
    private long account_id;

    @ManyToMany
    private List<Song> songs;

    public Playlist(String name, long account_id) {
        this.name = name;
        this.account_id = account_id;
    }

    public Playlist() {
    }
}
