package com.becasemodule6.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "singer_avatar", columnDefinition = "LONGTEXT")
    private String singer_avatar;

    private String singer_name;

    private String singer_gender;

    private String birthday;

    private String music_genre;

    @Column(name = "story", columnDefinition = "LONGTEXT")
    private String story;

    private int year;

    private String band;

    private String hot_music;

    @Column(name = "information", columnDefinition = "LONGTEXT")
    private String information;


}