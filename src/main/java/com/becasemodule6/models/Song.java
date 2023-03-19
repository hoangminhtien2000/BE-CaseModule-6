package com.becasemodule6.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String song_name;

    private String description;

    @Column(name = "file_mp3", columnDefinition = "LONGTEXT")
    private String file_mp3;

    @Column(name = "song_avatar", columnDefinition = "LONGTEXT")
    private String song_avatar;

    private String author;

    private String posted;

    private String album;

    private String song_music_genre;

    private Long listens;

    private Long likes;



}

