package com.becasemodule6.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaylistSongId {
    private long playlist_id;
    private long song_id;
}
