package com.becasemodule6.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", columnDefinition = "VARCHAR(50)", unique = true)
    private String username;

    private String password;

    private String full_name;

    private String gender;

    private String gmail;

    private String address;

    private String phone_number;

    @Column(name = "avatar", columnDefinition = "LONGTEXT")
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;


}
