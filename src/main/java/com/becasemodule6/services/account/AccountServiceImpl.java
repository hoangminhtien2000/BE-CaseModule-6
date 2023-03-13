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
        return new User(account.getUsername(), account.getPassword(), account.getRoles());
    }

    public Account findAccountByUsername(String username) {
        return accountRepo.findAccountByUsername(username);
    }

    public Boolean checkGmail(String gmail, long id) {
        Account account = accountRepo.findAccountByGmail(gmail);
        if (account == null) {
            return true;
        }
        if (gmail.equals(account.getGmail()) && id == account.getId()) {
            return true;
        }
        if (!gmail.equals(account.getGmail()) && id == account.getId()) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkUsername(String username) {
        Account account = accountRepo.findAccountByUsername(username);
        if (account == null) {
            return true;
        } else {
            return false;
        }
    }
}
