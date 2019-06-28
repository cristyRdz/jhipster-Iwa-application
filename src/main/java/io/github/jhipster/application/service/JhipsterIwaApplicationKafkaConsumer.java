package io.github.jhipster.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JhipsterIwaApplicationKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(JhipsterIwaApplicationKafkaConsumer.class);
    private static final String TOPIC = "topic_jhipsteriwaapplication";

    @KafkaListener(topics = "topic_jhipsteriwaapplication", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
