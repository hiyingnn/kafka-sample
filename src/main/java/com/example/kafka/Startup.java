package com.example.kafka;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Startup implements ApplicationListener<ApplicationReadyEvent> {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Startup(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        kafkaTemplate.send("test", "hello");
    }

}
