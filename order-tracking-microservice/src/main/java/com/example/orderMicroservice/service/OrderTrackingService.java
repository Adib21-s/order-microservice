package com.example.orderMicroservice.service;

import com.example.orderMicroservice.entity.OrderTracking;
import com.example.orderMicroservice.repository.OrderTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderTrackingService {
    @Autowired
    private OrderTrackingRepository repository;

    public OrderTracking getOrderTracking(int orderID) {
        return repository.findById(orderID)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void updateOrderStatus(int orderID, String status, LocalDate deliveryDate) {
        OrderTracking order = repository.findById(orderID)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setOrderStatus(status);
        order.setEstimatedDelivery(deliveryDate);
        repository.save(order);
    }
}
