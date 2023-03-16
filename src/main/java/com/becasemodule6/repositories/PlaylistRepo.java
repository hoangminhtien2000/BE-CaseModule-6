package com.becasemodule6.repositories;

import com.becasemodule6.models.Playlist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaylistRepo extends CrudRepository<Playlist, Long> {

    @Query("SELECT p FROM Playlist p WHERE p.name = :name and p.account_id = :id")
    Playlist findPlaylistByNameAndIdAccount(String name, long id);

    @Query("SELECT p FROM Playlist p WHERE p.account_id = :id")
    List<Playlist> findAllByAccountId(long id);


}
