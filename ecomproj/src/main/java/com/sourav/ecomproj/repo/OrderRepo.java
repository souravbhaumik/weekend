package com.sourav.ecomproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.ecomproj.model.Order;
import java.util.Optional;


public interface OrderRepo extends JpaRepository<Order, Integer> {

    Optional<Order> findByOrderId(String orderId);

}
