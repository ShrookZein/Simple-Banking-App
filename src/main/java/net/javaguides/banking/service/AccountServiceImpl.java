package net.javaguides.banking.service;

import net.javaguides.banking.Repository.AccountRepository;
import net.javaguides.banking.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        return null;
    }
}
