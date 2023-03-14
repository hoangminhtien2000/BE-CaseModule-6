package com.becasemodule6.controllers;

import com.becasemodule6.models.Playlist;
import com.becasemodule6.models.Song;
import com.becasemodule6.services.account.AccountServiceImpl;
import com.becasemodule6.models.Account;
import com.becasemodule6.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    AccountServiceImpl accountService;

    List<Role> roles = new ArrayList<>();
    List<Playlist> playlists = new ArrayList<>();
    List<Song> songs = new ArrayList<>();

    @PostMapping("/save")
    public void save(@RequestBody Account account) {
        Role role = new Role(1);
        roles.add(role);

        String avatar = "https://i.pinimg.com/564x/bf/d0/86/bfd086c4e3a9a69e9889267cb739bebc.jpg";
        account.setAvatar(avatar);
        account.setRoles(roles);
        account.setPlaylist(playlists);
        accountService.save(account);
    }

    @GetMapping("/show")
    public List<Account> getAll() {
        return accountService.findAll();
    }
}
