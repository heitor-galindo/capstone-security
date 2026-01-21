package com.ebanking.accountms.controller;

import com.ebanking.accountms.entities.Account;
import com.ebanking.accountms.repository.AccountRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/account")
public class AccountController {

  @Autowired private AccountRepository accountRepository;

  @GetMapping("/all")
  //  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<List<Account>> getAllAccounts() {
    List<Account> accounts = accountRepository.findAll();
    return new ResponseEntity<>(accounts, HttpStatus.OK);
  }

  @PostMapping()
  //  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    Account saved = accountRepository.save(account);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }
}
