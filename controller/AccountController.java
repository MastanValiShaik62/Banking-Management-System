package com.example.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.banking.entity.Account;
import com.example.banking.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create/{userId}")
    public Account createAccount(@PathVariable Long userId) {
        return accountService.createAccount(userId);
    }

    @PutMapping("/deposit/{accountId}/{amount}")
    public Account deposit(@PathVariable Long accountId,
                           @PathVariable Double amount) {
        return accountService.deposit(accountId, amount);
    }
}