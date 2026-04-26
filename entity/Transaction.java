package com.example.banking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // DEPOSIT, WITHDRAW, TRANSFER

    private Double amount;

    private LocalDateTime timestamp;

    @ManyToOne
    private Account fromAccount;

    @ManyToOne
    private Account toAccount;
}
