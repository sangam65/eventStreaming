package com.eventStreaming.Consumer.entities;

import java.time.Instant;
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="sensor_events")
@Data
public class SensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="sensor_id",nullable=false)
    private int sensorId;

    @Column(name="value",nullable=false)
    private double value;

    @Column(name="event_type")
    private String eventType;
    @Column(name="timestamp",columnDefinition = "timestamptz")
    private Instant timeStamp;

    @Column(name="metatdata",columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> metatdata;

}
