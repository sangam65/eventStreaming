package com.eventStreaming.Consumer.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eventStreaming.Consumer.entities.SensorEntity;
import com.eventStreaming.Consumer.model.SensorEvent;
import com.eventStreaming.Consumer.repository.SensorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SensorService {
    private final SensorRepository sensorRepository;

    @Transactional
    public void saveSensorEvents(List<SensorEvent> sensorEvents,String eventType){
        List<SensorEntity>sensorEntities=new ArrayList<>();
        
        if(eventType.equals("temperature-events")){
            sensorEntities=sensorEvents.stream().filter(s->s.getValue()>=-50&&s.getValue()<60)
            .filter(s->s.getSensorId()>=1&&s.getSensorId()<=1000)
            .filter(s->s.getTimeStamp().isBefore(LocalDateTime.now()))
            .map(t->mapToSensorEntity(t, eventType)).toList();
        }
        else{
             sensorEntities=sensorEvents.stream().filter(s->s.getValue()>=1&&s.getValue()<=100)
             .filter(s->s.getSensorId()>=1&&s.getSensorId()<=1000)
             .filter(s->s.getTimeStamp().isBefore(LocalDateTime.now()))
             .map(t->mapToSensorEntity(t, eventType)).toList();
        }

        
        sensorRepository.saveAll(sensorEntities);

    }
    private SensorEntity mapToSensorEntity(SensorEvent sensorEvent,String eventType){
        SensorEntity sensorEntity=new SensorEntity();
        sensorEntity.setEventType(eventType);
        sensorEntity.setSensorId(sensorEvent.getSensorId());
        sensorEntity.setMetatdata(sensorEvent.getMetatdata());
        sensorEntity.setValue(sensorEvent.getValue());
        LocalDateTime localDateTime=sensorEvent.getTimeStamp();
       Instant instant= localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        sensorEntity.setTimeStamp(instant);
        return sensorEntity;
    }

}
