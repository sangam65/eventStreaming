package com.eventStreaming.ProducerApp.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

import com.eventStreaming.ProducerApp.model.HumidityEvent;
import com.eventStreaming.ProducerApp.model.TemperatureEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventProducerService {

    private final KafkaTemplate<String,Object> kafkaTemplate;
   
    public void sendTemperature(TemperatureEvent temperatureEvent){
        String key = "sensor_" + temperatureEvent.getSensorId();
        kafkaTemplate.send("temperature-events",key,temperatureEvent);
    }
    public void sendHumidity(HumidityEvent humidityEvent){
          String key = "sensor_" + humidityEvent.getSensorId();
        kafkaTemplate.send("humidity-events",key,humidityEvent);
    }
}
