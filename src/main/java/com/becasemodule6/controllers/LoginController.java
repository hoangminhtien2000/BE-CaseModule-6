package com.becasemodule6.controllers;

import com.becasemodule6.models.Account;
import com.becasemodule6.models.dto.AccountToken;
import com.becasemodule6.services.JwtService;
import com.becasemodule6.services.account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AccountServiceImpl accountService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @PostMapping
    public AccountToken login(@RequestBody Account account) {
        // tạo ra 1 đối tượng xác thực
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword())
        );
        // nơi chứa đối tượng đang đăng nhập
        // truyền đối tượng đăng nhập vào securityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // tạo ra token
        String token = jwtService.createToken(authentication);
        Account account1 = accountService.findAccountByUsername(account.getUsername());

        return new AccountToken(account1.getId() ,account.getUsername(), account1.getFull_name(), account1.getGender(), account1.getGmail(), account1.getAddress(), account1.getPhone_number(),account1.getAvatar(), account1.getRoles(), account1.getPlaylist(),token);
    }

}
