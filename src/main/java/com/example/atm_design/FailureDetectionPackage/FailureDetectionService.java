package com.example.atm_design.FailureDetectionPackage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FailureDetectionService {


    private final FailureDetectionRepository failureRepository;

    public List<FailureDetectionEntity> getAllFailures() {
        return failureRepository.findAll();
    }
}
