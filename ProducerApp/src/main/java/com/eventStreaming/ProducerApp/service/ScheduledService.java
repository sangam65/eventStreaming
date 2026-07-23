package com.eventStreaming.ProducerApp.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.eventStreaming.ProducerApp.component.EventProducerComponent;
import com.eventStreaming.ProducerApp.model.TemperatureEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduledService {
    private final EventProducerComponent eventProducerService;

    @Scheduled(fixedRate = 1) // every ms 10 events
    public void sendTemperateEvents(){
        List<String>locations=List.of("Delhi","Mumbai","Kolkata","Chennai","Dehdradun");
        List<Double>temp=List.of(35.6,32.5,33.98,39.45,25.56);
            Random random = new Random();
        // log.info("scheduler running");
       for(int i=0; i<10; i++){
        Map<String,Object> mp = new HashMap<>();
        int tempIndex = random.nextInt(temp.size());
        int sensorId = random.nextInt(1, 1001);  // 1-1000
        
        mp.put("location", locations.get(tempIndex));
        eventProducerService.sendTemperature(
            new TemperatureEvent(sensorId, temp.get(tempIndex), LocalDateTime.now(), mp)
        );
    }
    }

}
