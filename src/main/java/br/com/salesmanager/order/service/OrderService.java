package br.com.salesmanager.order.service;

import br.com.salesmanager.order.kafka.OrderProducer;
import br.com.salesmanager.order.model.Order;
import br.com.salesmanager.order.model.enums.OrderStatus;
import br.com.salesmanager.order.model.dto.OrderDTO;
import br.com.salesmanager.order.model.mapper.OrderMapper;
import br.com.salesmanager.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderProducer orderProducer;

    public Order insert(OrderDTO orderDTO) {
        var order = orderMapper.mapOrderDTOToOrder(orderDTO);
        order.setOrderStatus(OrderStatus.PENDING);
        order = orderRepository.insert(order);
        orderProducer.sendMessage(order);

        return order;
    }

    public Order updateOrderStatus(Order order, OrderStatus orderStatus) {
        order.setOrderStatus(orderStatus);
        return this.save(order);
    }

    public Optional<Order> findById(String customerId){
        return orderRepository.findById(customerId);
    }

    private Order save(Order order) {
        return orderRepository.save(order);
    }
}
