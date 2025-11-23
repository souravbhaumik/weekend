package com.sourav.ecomproj.model.dto;

public record OrderItemRequest(
    int productId,
    int qty
) {
    
}
