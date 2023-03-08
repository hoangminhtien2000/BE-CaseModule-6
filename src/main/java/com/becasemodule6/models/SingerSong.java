package com.becasemodule6.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SingerSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Singer singer;
    @ManyToOne
    private Song song;
}
