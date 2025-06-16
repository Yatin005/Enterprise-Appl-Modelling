package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "publishers") 
public class Publisher {
    @Id
    private long pubId;  
    
    private String address;
    private String name;

    public Publisher() {}

    public Publisher(long pubId, String address, String name) {
        this.pubId = pubId;
        this.address = address;
        this.name = name;
    }

    // Getters and setter
    public long getPubId() {
        return pubId;
    }

    public void setPubId(long pubId) {
        this.pubId = pubId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Publisher [pubId=" + pubId + ", address=" + address + ", name=" + name + "]";
    }
}