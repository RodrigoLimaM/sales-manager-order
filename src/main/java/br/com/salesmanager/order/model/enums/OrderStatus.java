package br.com.salesmanager.order.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PROCESSING_PAYMENT("Processando pagamento"),
    APPROVED("Pedido aprovado"),
    CANCELLED("Pedido cancelado"),
    PREPARING_FOR_SHIPPING("Preparando para envio"),
    IN_SEPARATION("Em separação"),
    SENT_TO_CARRIER("Enviado para transportadora"),
    OUT_FOR_SHIPMENT("Saiu para entrega"),
    DELIVERED("Entregue"),
    MISSING_RECIPIENT("Destinatário ausente"),
    MISPLACED("Extraviado"),
    ;

    private String description;
}
