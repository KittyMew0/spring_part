package com.example.sem4and3task.payment;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PayPalPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Paid $" + amount + " using PayPal.";
    }
}
