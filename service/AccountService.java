package com.example.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.banking.entity.Account;
import com.example.banking.entity.User;
import com.example.banking.repository.AccountRepository;
import com.example.banking.repository.UserRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    // 🔹 Create Account
    public Account createAccount(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = new Account();
        account.setAccountNumber("ACC" + System.currentTimeMillis());
        account.setBalance(0.0);
        account.setUser(user);

        return accountRepository.save(account);
    }

    // 🔹 Deposit Money
    @Transactional
    public Account deposit(Long accountId, Double amount) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (amount <= 0) {
            throw new RuntimeException("Amount must be positive");
        }

        account.setBalance(account.getBalance() + amount);

        return accountRepository.save(account);
    }
}