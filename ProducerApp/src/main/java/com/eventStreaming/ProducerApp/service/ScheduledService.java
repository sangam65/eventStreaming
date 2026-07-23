package com.eventStreaming.ProducerApp.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.eventStreaming.ProducerApp.model.TemperatureEvent;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduledService {
    private final EventProducerService eventProducerService;

    @Scheduled(cron = "0 0 12 * * *")
    public void sendTemperateEvents(){
        List<String>locations=List.of("Delhi","Mumbai","Kolkata","Chennai","Dehdradun");
        List<Double>temp=List.of(35.6,32.5,33.98,39.45,25.56);
        for(int i=0;i<1000;i++){
            Map<String,Object>mp=new HashMap<>();
            int ind=((int)(Math.random()))%temp.size();
            mp.put("location",locations.get(ind));
            eventProducerService.sendTemperature(new TemperatureEvent(i, temp.get(ind), LocalDateTime.now(), mp));
        }
    }

}
