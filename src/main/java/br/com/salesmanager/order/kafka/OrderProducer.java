package br.com.salesmanager.order.kafka;

import br.com.salesmanager.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderProducer {

    private static final String TOPIC = "yje6oae7-NEW_ORDER";

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendMessage(Order message) {
        log.info("Produced message: {}, Topic: {}", message, TOPIC);
        kafkaTemplate.send(TOPIC, message);
    }
}
