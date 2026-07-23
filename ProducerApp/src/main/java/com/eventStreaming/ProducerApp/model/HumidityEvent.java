package com.eventStreaming.ProducerApp.model;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;
@Data
public class HumidityEvent {
     private int sensorId;
    private double value;
    private LocalDateTime timeStamp;
    private Map<String,Object>metatdata;

}
