package br.com.salesmanager.order.service;

import br.com.salesmanager.order.model.Order;
import br.com.salesmanager.order.model.OrderStatus;
import br.com.salesmanager.order.model.dto.OrderDTO;
import br.com.salesmanager.order.model.mapper.OrderMapper;
import br.com.salesmanager.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderProducer orderProducer;

    public Order insert(OrderDTO orderDTO) {
        var order = orderMapper.mapOrderDTOTOOrder(orderDTO);
        order.setOrderStatus(OrderStatus.PENDING);
        order = orderRepository.insert(order);
        orderProducer.sendMessage(order);

        return order;
    }
}
