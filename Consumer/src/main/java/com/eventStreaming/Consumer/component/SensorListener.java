package com.eventStreaming.Consumer.component;


import java.util.List;

// import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.eventStreaming.Consumer.model.SensorEvent;
import com.eventStreaming.Consumer.service.SensorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class SensorListener {
    private final SensorService sensorService;

    @KafkaListener(topics = "humidity-events",concurrency = "5")
    public void consumeHumidity(List<SensorEvent> sensorEvents){
    //    log.info("sensor id {} temp {}",sensorEvent.getSensorId(),sensorEvent.getValue());
       sensorService.saveSensorEvents(sensorEvents,"humidity-events" );

    }
     @KafkaListener(topics = "temperature-events")
    public void consumeTemperature(List<SensorEvent> sensorEvents){
   
       sensorService.saveSensorEvents( sensorEvents,"temperature-events" );

    }
}
