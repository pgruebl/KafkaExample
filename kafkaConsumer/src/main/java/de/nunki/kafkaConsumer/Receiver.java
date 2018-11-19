package de.nunki.kafkaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @Value("${app.topic}")
    private String topic;

    @KafkaListener(topics = "${app.topic}")
    public void listen(@Payload String message) {
        LOG.info("received message='{}'", message);
    }
}
