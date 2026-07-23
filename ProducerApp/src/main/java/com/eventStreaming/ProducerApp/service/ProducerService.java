package com.eventStreaming.ProducerApp.service;

import org.springframework.stereotype.Service;

import com.eventStreaming.ProducerApp.component.EventProducerComponent;
import com.eventStreaming.ProducerApp.model.HumidityEvent;
import com.eventStreaming.ProducerApp.model.TemperatureEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final EventProducerComponent eventProducerService;

    
    public void sendTemperature(TemperatureEvent temperatureEvent){
       eventProducerService.sendTemperature(temperatureEvent);
    }
    
    public void sendHumidity(HumidityEvent humidityEvent){
       eventProducerService.sendHumidity(humidityEvent);
    }

}
