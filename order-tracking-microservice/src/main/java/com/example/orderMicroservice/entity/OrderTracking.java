package com.example.orderMicroservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ORDER_MICROSERVICE")
public class OrderTracking {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	    @SequenceGenerator(name = "order_seq", sequenceName = "ORDER_SEQ", allocationSize = 1)
	    @Column(name = "ORDER_ID")
	    private int orderID;

	    @Column(name = "ORDER_STATUS", nullable = false)
	    private String orderStatus;

	    @Column(name = "SHIP_ADDRESS")
	    private String shipAddress;

	    @Column(name = "ESTIMATED_DELIVERY")
	    private LocalDate estimatedDelivery;

	    @Column(name = "COURIER_SERVICE")
	    private String courierService;

	    @Column(name = "TRACKING_NUMBER")
	    private String trackingNumber;

    // Getters and Setters
    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public String getShipAddress() { return shipAddress; }
    public void setShipAddress(String shipAddress) { this.shipAddress = shipAddress; }

    public LocalDate getEstimatedDelivery() { return estimatedDelivery; }
    public void setEstimatedDelivery(LocalDate estimatedDelivery) { this.estimatedDelivery = estimatedDelivery; }

    public String getCourierService() { return courierService; }
    public void setCourierService(String courierService) { this.courierService = courierService; }

    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }
}
