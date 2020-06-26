package com.bankwithmint.Listener.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

@Configuration
public class kafkaServiceImpl {

    private final Logger log = LoggerFactory.getLogger(kafkaServiceImpl.class);

    final private String TOPIC = "com.mintfintech.card_verified";

    public kafkaServiceImpl() {
    }

    @KafkaListener(topics = TOPIC, groupId = "903")
    public void listen(String payload, Message<String> message) {
        MessageHeaders headers = message.getHeaders();
        log.info("Received from partition [{}] with timestamp [{}]",
                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID),
                headers.get(KafkaHeaders.RECEIVED_TIMESTAMP));
        log.info("Gratefully Recieved [{}]", message.getPayload());
    }

}
