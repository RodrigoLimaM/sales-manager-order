package br.com.salesmanager.order.model;

import br.com.salesmanager.order.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "orders")
@Getter
@ToString
@AllArgsConstructor
@Builder
public class Order {

    @MongoId(value = FieldType.OBJECT_ID)
    private final String _id;

    @Field(name = "customer_id")
    private final String customerId;

    @Field(name = "product_id")
    private final String productId;

    @Field(name = "product_quantity")
    private final Integer productQuantity;

    @Field(name = "order_total_value")
    private BigDecimal orderTotalValue;

    @Field(name = "order_status")
    private OrderStatus orderStatus;

    @Field(name = "order_address")
    private Address address;

    @CreatedDate
    @Field(name = "creation_date")
    private final LocalDateTime creationDate;

    @LastModifiedDate
    @Field(name = "update_date")
    private LocalDateTime updateDate;

    public String getOrderId() {
        return _id;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
