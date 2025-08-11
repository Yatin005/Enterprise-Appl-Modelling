package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "fees")
public class Fee {

    @Id
    private String id;
    private String feeId;
    private boolean feeType;
    private double feeAmt;
    private double feeSalesTax;
    private LocalDateTime feeDateTime;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFeeId() {
        return feeId;
    }
    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public boolean isFeeType() {
        return feeType;
    }
    public void setFeeType(boolean feeType) {
        this.feeType = feeType;
    }

    public double getFeeAmt() {
        return feeAmt;
    }
    public void setFeeAmt(double feeAmt) {
        this.feeAmt = feeAmt;
    }

    public double getFeeSalesTax() {
        return feeSalesTax;
    }
    public void setFeeSalesTax(double feeSalesTax) {
        this.feeSalesTax = feeSalesTax;
    }

    public LocalDateTime getFeeDateTime() {
        return feeDateTime;
    }
    public void setFeeDateTime(LocalDateTime feeDateTime) {
        this.feeDateTime = feeDateTime;
    }
}
