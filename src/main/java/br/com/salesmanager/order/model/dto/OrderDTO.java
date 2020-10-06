package br.com.salesmanager.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Builder
public class OrderDTO {

    @NotBlank
    @NotNull
    private final String customerId;

    @NotBlank
    @NotNull
    private final String productId;

    @NotNull
    private final Integer productQuantity;
}
