package com.example.atm_design.FailureDetectionPackage;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atm")
@RequiredArgsConstructor
public class FailureDetactionController {

    private final FailureDetectionService failureDetectionService;
    @GetMapping("/failures")
    public List<FailureDetectionEntity> getFailures() {
        return failureDetectionService.getAllFailures();
    }
}
