package com.example.atm_design.TransactionPackage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    public List<TransactionEntity> getTransactionsInLast24Hours() {
        LocalDateTime yesterday = LocalDateTime.now().minusHours(24);
        return transactionRepository.findByTimestampAfter(yesterday);
    }

    public List<TransactionEntity> getTransactionsBreakdown() {
        return transactionRepository.findAll();
    }
}
