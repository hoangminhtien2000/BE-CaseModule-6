package com.becasemodule6.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingerSongId {
    private Long singer_id;
    private Long song_id;
}
