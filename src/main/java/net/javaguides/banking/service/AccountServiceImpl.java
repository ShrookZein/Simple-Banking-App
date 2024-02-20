package net.javaguides.banking.service;

import net.javaguides.banking.Repository.AccountRepository;
import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account=modelMapper.map(accountDto,Account.class);
        Account savedAccount=accountRepository.save(account);

        return modelMapper.map(savedAccount,AccountDto.class);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account dose Not Exit"));
        AccountDto accountDto=modelMapper.map(account,AccountDto.class);
        return accountDto;
    }
}
