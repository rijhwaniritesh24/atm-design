package com.example.atm_design.CameraFootagePackage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CameraFootageRepository extends JpaRepository<CameraFootageEntity, UUID> {
    List<CameraFootageEntity> findByAtmIdAndStartTimeBetween(String atmId, LocalDateTime startTime, LocalDateTime endTime);

}
