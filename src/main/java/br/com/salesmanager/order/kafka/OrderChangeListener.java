package br.com.salesmanager.order.kafka;

import br.com.salesmanager.order.model.Order;
import br.com.salesmanager.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class OrderChangeListener {

    private static final String TOPIC = "ORDER_STATUS_CHANGE";

    @Autowired
    OrderService orderService;

    @KafkaListener(topics = "ORDER_STATUS_CHANGE", groupId = "sales_manager", containerFactory = "userKafkaListenerContainerFactory")
    public void consume(OrderChange orderChange) {
        log.info("Message Listened: {}, Topic: {}", orderChange, TOPIC);

        var order = orderService.findById(orderChange.getOrderId())
                .map(ord -> orderService.updateOrderStatus(ord, orderChange.getOrderStatus()))
                .orElseThrow(() -> new RuntimeException("Null order"));

        log.info("Order update: {}", order);
    }
}
