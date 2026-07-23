package com.eventStreaming.Consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventStreaming.Consumer.entities.SensorEntity;

public interface SensorRepository extends JpaRepository<SensorEntity,Integer>{

}
