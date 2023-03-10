package com.becasemodule6.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String singer_name;

    private String singer_gender;

    private String birthday;

    private String music_genre;

    private String story;

    private int year;

    private String band;

    private String hot_music;

    private String information;

}
