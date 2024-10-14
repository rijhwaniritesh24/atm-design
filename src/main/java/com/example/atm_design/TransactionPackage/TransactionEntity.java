package com.example.atm_design.TransactionPackage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID transactionId;
    private String atmId;
    private String customerId;
    private String type; // "deposit", "withdrawal", "balance"
    private Double amount;
    private LocalDateTime timestamp;
    private String status; // "success", "failure"
}
