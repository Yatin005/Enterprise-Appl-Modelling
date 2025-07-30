package com.va.week10;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private double feeAmount;

    public Fee() {}

    public Fee(String orderId, double feeAmount) {
        this.orderId = orderId;
        this.feeAmount = feeAmount;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public double getFeeAmount() { return feeAmount; }
    public void setFeeAmount(double feeAmount) { this.feeAmount = feeAmount; }
}