package com.eventStreaming.ProducerApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<String> getHealthResponse(){
        return ResponseEntity.ok("Service is up and running");
    }

}
