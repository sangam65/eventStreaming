package com.eventStreaming.Consumer.model;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;

@Data
public class SensorEvent {
    private int sensorId;
    private double value;
    private LocalDateTime timeStamp;
    private Map<String, Object> metatdata;

}
