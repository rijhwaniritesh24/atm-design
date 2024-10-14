package com.example.atm_design.TransactionPackage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findByTimestampAfter(LocalDateTime timestamp);
    List<TransactionEntity> findDistinctCustomerIdByTimestampAfter(LocalDateTime timestamp);
}
