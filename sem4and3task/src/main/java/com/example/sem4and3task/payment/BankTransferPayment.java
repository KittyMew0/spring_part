package com.example.sem4and3task.payment;

import org.springframework.stereotype.Component;

@Component("bankTransfer")
public class BankTransferPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Paid $" + amount + " using Bank Transfer.";
    }
}
