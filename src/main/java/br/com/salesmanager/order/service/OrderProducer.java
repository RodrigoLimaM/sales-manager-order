package br.com.salesmanager.order.service;

import br.com.salesmanager.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final String TOPIC = "STORE_NEW_ORDER";

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendMessage(Order message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
