package com.sourav.ecomproj.model.dto;

import java.math.BigDecimal;

public record OrderItemResponse (

    String productName,
    int qty,
    BigDecimal subTotal

) {
    
}
