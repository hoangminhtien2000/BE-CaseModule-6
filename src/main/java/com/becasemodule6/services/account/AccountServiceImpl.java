package com.becasemodule6.services.account;

import com.becasemodule6.models.Account;
import com.becasemodule6.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService, UserDetailsService {
    @Autowired
    AccountRepo accountRepo;

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepo.findAll();
    }

    @Override
    public void save(Account account) {
         accountRepo.save(account);
    }

    @Override
    public void delete(Long id) {
        accountRepo.deleteById(id);
    }

    @Override
    public Account findById(Long id) {
        return accountRepo.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findAccountByUsername(username);
        return new User(account.getUsername(),account.getPassword(),account.getRoles());
    }

    public Account findAccountByUsername(String username){
        return accountRepo.findAccountByUsername(username);
    }
}
