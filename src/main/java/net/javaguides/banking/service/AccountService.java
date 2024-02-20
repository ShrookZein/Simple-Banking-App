package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import org.springframework.stereotype.Service;

//@Service
public interface  AccountService {
    public AccountDto createAccount(AccountDto accountDto);
    public AccountDto getAccountById(Long id);
}
