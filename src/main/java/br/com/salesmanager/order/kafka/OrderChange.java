package br.com.salesmanager.order.kafka;

import br.com.salesmanager.order.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderChange {

    private String customerId;

    private String orderId;

    private OrderStatus orderStatus;
}
