package com.example.orderMicroservice.repository;

import com.example.orderMicroservice.entity.OrderTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTrackingRepository extends JpaRepository<OrderTracking, Integer> {
}
