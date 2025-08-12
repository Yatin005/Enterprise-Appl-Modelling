package com.yatin.spring.finalex;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class Payment {
    @Id
    private String id;
    private int amount;
    private String date;

    public Payment() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}