package com.becasemodule6.repositories;

import com.becasemodule6.models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepo extends CrudRepository<Account, Long> {
    Account findAccountByUsername(String username);

    @Query("SELECT a FROM Account a WHERE a.gmail = :gmail")
    Account findAccountByGmail(String gmail);

}
