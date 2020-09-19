package br.com.salesmanager.order.service;

import br.com.salesmanager.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderProducer {

    private static final String TOPIC = "NEW_ORDER";

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendMessage(Order message) {
        log.info("Produced message: {}, Topic: {}", message, TOPIC);
        kafkaTemplate.send(TOPIC, message);
    }
}
