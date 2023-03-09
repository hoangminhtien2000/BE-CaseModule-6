package com.becasemodule6.repositories;

import com.becasemodule6.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {
    Account findAccountByUsername(String username);
}
