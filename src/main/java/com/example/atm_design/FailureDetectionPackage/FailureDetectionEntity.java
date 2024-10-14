package com.example.atm_design.FailureDetectionPackage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FailureDetectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID failureId;
    private String atmId;
    private String type; // "system", "device"
    private String description;
    private String transactionType;
    private LocalDateTime timestamp;
}
