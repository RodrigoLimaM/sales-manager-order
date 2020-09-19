package br.com.salesmanager.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "orders")
@Getter
@ToString
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @Field(name = "_id")
    private final String orderId;

    @Field(name = "customer_id")
    private final Long customerId;

    @Field(name = "product_name")
    private final String productName;

    @Field(name = "order_value")
    private final BigDecimal value;

    @Field(name = "order_status")
    private OrderStatus orderStatus;

    @CreatedDate
    @Field(name = "creation_date")
    private final LocalDateTime creationDate;

    @LastModifiedDate
    @Field(name = "update_date")
    private LocalDateTime updateDate;

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
