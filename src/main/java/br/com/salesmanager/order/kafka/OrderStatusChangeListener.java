package br.com.salesmanager.order.kafka;

import br.com.salesmanager.order.model.enums.OrderStatus;
import br.com.salesmanager.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class OrderStatusChangeListener {

    private static final String TOPIC = "yje6oae7-ORDER_STATUS_CHANGE";

    @Autowired
    OrderService orderService;

    @KafkaListener(topics = "yje6oae7-ORDER_STATUS_CHANGE")
    public void consume(OrderChange orderChange) {
        log.info("Message Listened: {}, Topic: {}", orderChange, TOPIC);

        var order = orderService.findById(orderChange.getOrderId())
                .map(ord -> orderService.updateOrderStatus(ord, orderChange.getOrderStatus()))
                .orElseThrow(() -> new RuntimeException("Null order"));

        if(order.getOrderStatus() == OrderStatus.APPROVED) {
            Object subtractQuantityResponse = orderService.subtractQuantity(order.getProductId(), order.getProductQuantity());
            log.info("Quantity updated: {}", subtractQuantityResponse);
        }


        log.info("Order update: {}", order);
    }
}
