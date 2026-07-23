package com.eventStreaming.ProducerApp.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicsCreationConfig {

    @Bean
    NewTopic createTemperatureTopic() {
        return TopicBuilder.name("temperature-events")
                .partitions(10)
                .replicas(3)
                .build();
    }

    @Bean
    NewTopic createHumidityTopic() {
        return TopicBuilder.name("humidity-events")
                .partitions(10)
                .replicas(3)
                .build();
    }
}
