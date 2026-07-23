package com.eventStreaming.Consumer.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.eventStreaming.Consumer.repository.SensorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MonitoringService {

    private final SensorRepository sensorRepository;
    private long lastCount = 0;

    @Scheduled(fixedRate = 60000)
    public void logProcessingStats() {
        try {
            long currentCount = sensorRepository.count();
            // Calculate DELTA (new events since last check)
            long processedThisMinute = currentCount - lastCount;

            // Log stats
            log.info("═══════════════════════════════════════════════════");
            log.info("CONSUMER STATS (Last 60 seconds)");
            log.info("Total events in DB: {}", currentCount);
            log.info("New events processed this minute: {}", processedThisMinute);
            log.info("Throughput: {}/sec", processedThisMinute / 60);
            log.info("═══════════════════════════════════════════════════");

            // Update for NEXT cycle
            lastCount = currentCount;
        } catch (Exception e) {
            log.error("Error logging stats", e);
        }

    }

}
