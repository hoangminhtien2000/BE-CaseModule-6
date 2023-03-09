package com.becasemodule6.models.dto;

import com.becasemodule6.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountToken {
    private Long id;
    private String username;
    private String password;
    private String full_name;
    private String gender;
    private String gmail;
    private String address;
    private String phone_number;
    private String avatar;
    private List<Role> roles;
    private String token;
}
