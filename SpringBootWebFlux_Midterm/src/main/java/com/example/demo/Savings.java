package com.example.demo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "savings")
public class Savings extends Account {
    private double interestRate;

    public Savings(String accountHolder, double balance, double interestRate) {
    	super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void depositMonthlyInterest() {
        double interest = getBalance() * interestRate;
        updateBalance(getBalance() + interest);
    }

    @Override
    public void deposit(double amount) {
        updateBalance(getBalance() + amount);
    }

    @Override
    public void withdrawal(double amount) {
        if (getBalance() >= amount) {
            updateBalance(getBalance() - amount);
        }
    }
}
