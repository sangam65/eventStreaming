package com.eventStreaming.ProducerApp.model;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureEvent {
    private int sensorId;
    private double value;
    private LocalDateTime timeStamp;
    private Map<String,Object>metatdata;
}
