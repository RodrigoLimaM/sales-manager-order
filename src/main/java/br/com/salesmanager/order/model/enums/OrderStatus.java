package br.com.salesmanager.order.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PROCESSING_PAYMENT("Processing Payment"),
    APPROVED("Approved"),
    CANCELLED("Cancelled"),
    PREPARING_FOR_SHIPPING("Preparing for shipping"),
    IN_SEPARATION("In separation"),
    SENT_TO_CARRIER("Sent to carrier"),
    OUT_FOR_SHIPMENT("Out for shipment"),
    DELIVERED("Delivered"),
    MISSING_RECIPIENT("Missing Recipient"),
    MISPLACED("Misplaced"),
    ;

    private String description;
}
