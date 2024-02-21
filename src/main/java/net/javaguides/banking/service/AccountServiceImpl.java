package net.javaguides.banking.service;

import net.javaguides.banking.Repository.AccountRepository;
import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public AccountDto depoit(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account dose Not Exit"));
        account.setBalance(account.getBalance()+amount);
        Account account1=accountRepository.save(account);
        AccountDto accountDto=modelMapper.map(account1,AccountDto.class);
        return accountDto;
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account dose Not Exit"));
        if(account.getBalance()<amount){
            throw  new RuntimeException("Insufficient");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account account1=accountRepository.save(account);
        AccountDto accountDto=modelMapper.map(account1,AccountDto.class);
        return accountDto;
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account>accounts=accountRepository.findAll();
        List<AccountDto>accountDtos=new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            accountDtos.add(modelMapper.map(accounts.get(i),AccountDto.class));
        }
        return accountDtos;
    }

    @Override
    public void deleteAccountById(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account dose Not Exit"));
        accountRepository.deleteById(id);
    }
}
