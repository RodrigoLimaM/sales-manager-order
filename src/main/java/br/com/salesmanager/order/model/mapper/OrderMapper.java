package br.com.salesmanager.order.model.mapper;

import br.com.salesmanager.order.model.Order;
import br.com.salesmanager.order.model.dto.OrderDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMapper {

    public Order mapOrderDTOToOrder(OrderDTO orderDTO, BigDecimal unitaryValue) {
        return Order.builder()
                .customerId(orderDTO.getCustomerId())
                .productId(orderDTO.getProductId())
                .productQuantity(orderDTO.getProductQuantity())
                .orderTotalValue(unitaryValue.multiply(BigDecimal.valueOf(orderDTO.getProductQuantity())))
                .address(orderDTO.getAddress())
                .build();
    }
}
