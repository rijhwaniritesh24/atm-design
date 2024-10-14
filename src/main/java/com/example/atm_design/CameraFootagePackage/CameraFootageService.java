package com.example.atm_design.CameraFootagePackage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CameraFootageService {
    private final CameraFootageRepository cameraFootageRepository;

    public List<CameraFootageEntity> getFootageByTimeRange(String atmId, LocalDateTime startTime, LocalDateTime endTime) {
        return cameraFootageRepository.findByAtmIdAndStartTimeBetween(atmId, startTime, endTime);
    }

    public Optional<CameraFootageEntity> getFootageById(UUID videoId) {
        return cameraFootageRepository.findById(videoId);
    }
}
