package com.example.sem4and3task.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentContext {

    private final Map<String, PaymentStrategy> paymentStrategies;

    @Autowired
    public PaymentContext(Map<String, PaymentStrategy> paymentStrategies) {
        this.paymentStrategies = paymentStrategies;
    }

    public String processPayment(String method, double amount) {
        PaymentStrategy strategy = paymentStrategies.get(method);
        if (strategy == null) {
            return "Invalid payment method: " + method;
        }
        return strategy.pay(amount);
    }
}
