package com.eventStreaming.ProducerApp.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventStreaming.ProducerApp.model.HumidityEvent;
import com.eventStreaming.ProducerApp.model.TemperatureEvent;

@Service
public class EventProducerService {

    private KafkaTemplate<String,Object> kafkaTemplate;
    @Transactional("kafkaTransactionManager")
    public void sendTemperature(TemperatureEvent temperatureEvent){
        kafkaTemplate.send("temperature-events",temperatureEvent);
    }
    @Transactional("kafkaTransactionManager")
    public void sendHumidity(HumidityEvent humidityEvent){
        kafkaTemplate.send("humidity-events",humidityEvent);
    }
}
