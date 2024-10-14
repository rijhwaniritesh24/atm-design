package com.example.atm_design.CameraFootagePackage;

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
public class CameraFootageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID videoId;
    private String atmId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String videoUrl;
}
