package com.sourav.ecomproj.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.ecomproj.model.Order;
import com.sourav.ecomproj.model.OrderItem;
import com.sourav.ecomproj.model.Product;
import com.sourav.ecomproj.model.dto.OrderItemRequest;
import com.sourav.ecomproj.model.dto.OrderItemResponse;
import com.sourav.ecomproj.model.dto.OrderRequest;
import com.sourav.ecomproj.model.dto.OrderResponse;
import com.sourav.ecomproj.repo.OrderRepo;
import com.sourav.ecomproj.repo.ProductRepo;

@Service
public class OrderService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo; 

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        String orderId = "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        order.setOrderId(orderId);
        order.setCustomerName(orderRequest.customerName());
        order.setEmail(orderRequest.email());
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest itemReq: orderRequest.items()) {
            Product product = productRepo.findById(itemReq.productId())
                                .orElseThrow(() -> new RuntimeException("Product not found!"));
            product.setStockQuantity(product.getStockQuantity() - itemReq.qty());
            productRepo.save(product);

            OrderItem orderItem = OrderItem.builder()
                                    .product(product)
                                    .qty(itemReq.qty())
                                    .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(itemReq.qty())))
                                    .order(order)
                                    .build();
            orderItems.add(orderItem);
        }

        order.setOrderItem(orderItems);
        Order savedOrder = orderRepo.save(order);

        List<OrderItemResponse> itemResponses = new ArrayList<>();
        for (OrderItem item: order.getOrderItem()) {
            OrderItemResponse orderItemResponse = new OrderItemResponse(
                item.getProduct().getName(), item.getQty(), item.getTotalPrice()
            );
            itemResponses.add(orderItemResponse);
        }

        OrderResponse orderResponse = new OrderResponse(
            savedOrder.getOrderId(), savedOrder.getCustomerName(), savedOrder.getEmail(), savedOrder.getStatus(), savedOrder.getOrderDate(), itemResponses
        );

        return orderResponse;   

    }

    public List<OrderResponse> getAllOrderResponses() {
        List<Order> orders = orderRepo.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        List<OrderItemResponse> itemResponses = new ArrayList<>();
        
        for (Order order: orders) {
            for (OrderItem item: order.getOrderItem()) {
                OrderItemResponse orderItemResponse = new OrderItemResponse(
                    item.getProduct().getName(), item.getQty(), item.getTotalPrice()
                );
                itemResponses.add(orderItemResponse);
            }

            OrderResponse orderResponse = new OrderResponse(
                order.getOrderId(), order.getCustomerName(), order.getEmail(), order.getStatus(), order.getOrderDate(), itemResponses
            );
            orderResponses.add(orderResponse);
        }
        return null;
    }

}
