package br.com.salesmanager.order.model.mapper;

import br.com.salesmanager.order.model.Order;
import br.com.salesmanager.order.model.dto.OrderDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order mapOrderDTOToOrder(OrderDTO orderDTO) {
        return Order.builder()
                .customerId(orderDTO.getCustomerId())
                .productName(orderDTO.getProductName())
                .value(orderDTO.getValue())
                .build();
    }
}
