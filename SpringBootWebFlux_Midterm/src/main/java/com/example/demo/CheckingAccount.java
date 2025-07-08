package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "checking")
public class CheckingAccount extends Account {
    private double insufficientFundFee;

    public CheckingAccount(String accountHolder, double balance, double insufficientFundFee) {
    	super(accountHolder, balance);
        this.insufficientFundFee = insufficientFundFee;
    }

    @Override
    public void deposit(double amount) {
        updateBalance(getBalance() + amount);
    }

    @Override
    public void withdrawal(double amount) {
        if (getBalance() >= amount) {
            updateBalance(getBalance() - amount);
        } else {
            updateBalance(getBalance() - insufficientFundFee);
        }
    }
}
