package com.becasemodule6.controllers;

import com.becasemodule6.models.Account;
import com.becasemodule6.models.dto.AccountToken;
import com.becasemodule6.services.account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountServiceImpl accountService;

    @PostMapping("/profile")
    public AccountToken saveProfile(@RequestBody AccountToken accountToken) {
        long id = accountToken.getId();
        Account account = accountService.findById(id);
        account.setUsername(accountToken.getUsername());
        account.setFull_name(accountToken.getFull_name());
        account.setAddress(accountToken.getAddress());
        account.setGmail(accountToken.getGmail());
        account.setPhone_number(accountToken.getPhone_number());
        accountService.save(account);
        return new AccountToken(id, account.getUsername(), account.getFull_name(), account.getGender(), accountToken.getGmail(), accountToken.getAddress(), accountToken.getPhone_number(), account.getAvatar(), account.getRoles(), accountToken.getToken());
    }

    @PostMapping("/save/avatar")
    public Account saveAvatar(@RequestBody Account account) {
        Account account1 = accountService.findById(account.getId());
        account1.setAvatar(account.getAvatar());
        accountService.save(account1);
        return account1;
    }

    @GetMapping("/show")
    public List<Account> getAll() {
        return accountService.findAll();
    }

    @PostMapping("/save/password")
    public Account savePassword(@RequestBody Account account) {
        Account account1 = accountService.findById(account.getId());
        account1.setPassword(account.getPassword());
        accountService.save(account1);
        return account1;
    }

    @GetMapping("/{id}")
    public Account findAccountById(@PathVariable long id) {
        return accountService.findById(id);
    }

}
