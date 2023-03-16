package com.becasemodule6.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaylistToken {
    private long id;
    private String name;
    private long account_id;
    private int active;
}
