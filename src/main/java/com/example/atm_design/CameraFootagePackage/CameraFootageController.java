package com.example.atm_design.CameraFootagePackage;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/atm")
@RequiredArgsConstructor
public class CameraFootageController {

    private final CameraFootageService cameraService;

    @GetMapping("/download")
    public ResponseEntity<List<CameraFootageEntity>> downloadFootage(
            @RequestParam String atmId,
            @RequestParam LocalDateTime startTime,
            @RequestParam LocalDateTime endTime) {




        List<CameraFootageEntity> footageList = cameraService.getFootageByTimeRange(atmId, startTime, endTime);
        return ResponseEntity.ok(footageList);
    }

    @GetMapping("/footage/{videoId}")
    public ResponseEntity<CameraFootageEntity> getFootageById(@PathVariable UUID videoId) {
        return cameraService.getFootageById(videoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
