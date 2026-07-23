package com.eventStreaming.Consumer.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<?> getHealthStatus() {
        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "service", "Consumer",
                "timestamp", LocalDateTime.now()));
    }

}
