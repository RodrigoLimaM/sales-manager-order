package br.com.salesmanager.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "SalesManagerProductClient", url = "${sales-manager-product.url}")
public interface SalesManagerProductClient {

    @GetMapping("/product/availability/{productId}")
    Boolean hasAvailableStock(@RequestParam Integer requestedQuantity,
                              @PathVariable String productId);

    @GetMapping("/product/unitaryValue/{productId}")
    BigDecimal getUnitaryValue(@PathVariable String productId);

    @PutMapping("/product/subtractQuantity/{productId}")
    Object subtractQuantity(@PathVariable String productId,
                               @RequestParam Integer quantity);
}