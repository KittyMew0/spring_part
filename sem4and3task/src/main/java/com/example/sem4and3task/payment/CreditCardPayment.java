package com.example.sem4and3task.payment;

import org.springframework.stereotype.Component;

@Component("creditCard")
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Paid $" + amount + " using Credit Card.";
    }
}
