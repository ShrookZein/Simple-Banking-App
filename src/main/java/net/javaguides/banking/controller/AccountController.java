package net.javaguides.banking.controller;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping
    public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto>getAccountById(@PathVariable Long id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto>deposit(@PathVariable Long id,@RequestBody Map<String, Double> request){
        return ResponseEntity.ok(accountService.depoit(id,request.get("amount")));
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>withdraw(@PathVariable Long id,@RequestBody Map<String, Double> request){
        return ResponseEntity.ok(accountService.withdraw(id,request.get("amount")));
    }
    @GetMapping
    public ResponseEntity<List<AccountDto>>getAccountById(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteAccountById(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return ResponseEntity.ok("Account is deleted successfully!");
    }
}
