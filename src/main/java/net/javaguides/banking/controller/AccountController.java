package net.javaguides.banking.controller;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping
    public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<AccountDto>getAccountById(@RequestParam Long id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }
}
