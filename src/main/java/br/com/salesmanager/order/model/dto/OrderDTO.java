package br.com.salesmanager.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class OrderDTO {

    @NotBlank
    @NotNull
    private final String productName;

    @NotBlank
    @NotNull
    private final String customerId;

    @NotBlank
    @NotNull
    private final BigDecimal value;
}
