package com.example.atm_design.FailureDetectionPackage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FailureDetectionRepository extends JpaRepository<FailureDetectionEntity, UUID> {
}
