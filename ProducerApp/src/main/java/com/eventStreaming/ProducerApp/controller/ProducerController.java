package com.eventStreaming.ProducerApp.controller;

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
    public ResponseEntity<?> eventTemperature(@RequestBody TemperatureEvent temperatureEvent){
        producerService.sendTemperature(temperatureEvent);
        return ResponseEntity.ok(Map.of("message","temperature event published successfully"));
    }

     @PostMapping("/humidity")
    public ResponseEntity<?> eventHumididty(@RequestBody HumidityEvent humidityEvent){
        producerService.sendHumidity(humidityEvent);
        return ResponseEntity.ok(Map.of("message","Humidity event published successfully"));
    }
}
