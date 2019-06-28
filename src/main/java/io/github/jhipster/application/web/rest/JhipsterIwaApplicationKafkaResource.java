package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.JhipsterIwaApplicationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/jhipster-iwa-application-kafka")
public class JhipsterIwaApplicationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterIwaApplicationKafkaResource.class);

    private JhipsterIwaApplicationKafkaProducer kafkaProducer;

    public JhipsterIwaApplicationKafkaResource(JhipsterIwaApplicationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
