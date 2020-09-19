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
    private String productName;

    @NotBlank
    @NotNull
    private Long customerId;

    @NotBlank
    @NotNull
    private BigDecimal value;
}
