package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface  AccountService {
    public AccountDto createAccount(AccountDto accountDto);
    public AccountDto getAccountById(Long id);
    public AccountDto depoit(Long id,double amount);
    public AccountDto withdraw(Long id,double amount);
    public List<AccountDto> getAllAccounts();
    public void deleteAccountById(Long id);
}
