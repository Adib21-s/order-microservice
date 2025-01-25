package com.example.orderMicroservice.controller;

import com.example.orderMicroservice.entity.OrderTracking;
import com.example.orderMicroservice.service.OrderTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/order-tracking")
public class OrderTrackingController {
	public class IndexController implements ErrorController{

	    private static final String PATH = "/error";

	    @RequestMapping(value = PATH)
	    public String error() {
	        return "Error handling";
	    }

	    public String getErrorPath() {
	        return PATH;
	    }
	}
	
    @Autowired
    private OrderTrackingService service;

    @GetMapping("/{orderID}")
    public ResponseEntity<OrderTracking> getOrderTracking(@PathVariable int orderID) {
        return ResponseEntity.ok(service.getOrderTracking(orderID));
    }
    @GetMapping("/health")
    public String healthCheck() {
        return "Application is running";
    }


    @PutMapping("/{orderID}")
    public ResponseEntity<String> updateOrderStatus(
            @PathVariable int orderID,
            @RequestBody Map<String, String> request) {
        String status = request.get("orderStatus");
        LocalDate deliveryDate = LocalDate.parse(request.get("estimatedDelivery"));
        service.updateOrderStatus(orderID, status, deliveryDate);
        return ResponseEntity.ok("Order status updated successfully");
    }
}
