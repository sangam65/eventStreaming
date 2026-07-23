package com.eventStreaming.ProducerApp.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventStreaming.ProducerApp.model.HumidityEvent;
import com.eventStreaming.ProducerApp.model.TemperatureEvent;
import com.eventStreaming.ProducerApp.service.ProducerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/temperature")
    public ResponseEntity<?> eventTemperature(@RequestBody TemperatureEvent temperatureEvent) {
        producerService.sendTemperature(temperatureEvent);
        return ResponseEntity.ok(Map.of(
                "status", "published",
                "topic", "temperature-events",
                "sensorId", temperatureEvent.getSensorId(),
                "value", temperatureEvent.getValue(),
                "timestamp", LocalDateTime.now()));
    }

    @PostMapping("/humidity")
    public ResponseEntity<?> eventHumidity(@RequestBody HumidityEvent humidityEvent) {
        producerService.sendHumidity(humidityEvent);
        return ResponseEntity.ok(Map.of(
                "status", "published",
                "topic", "humidity-events",
                "sensorId", humidityEvent.getSensorId(),
                "value", humidityEvent.getValue(),
                "timestamp", LocalDateTime.now()));
    }
}
