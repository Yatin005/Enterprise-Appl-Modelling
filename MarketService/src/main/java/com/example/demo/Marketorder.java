package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marketOrders")
public class Marketorder {

    @Id
    private String id;
    private String orderId;
    private double executedPrice;
    private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getExecutedPrice() {
		return executedPrice;
	}
	public void setExecutedPrice(double executedPrice) {
		this.executedPrice = executedPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
