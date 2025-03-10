package com.example.sem4and3task.controller;

import com.example.sem4and3task.model.Product;
import com.example.sem4and3task.payment.PaymentContext;
import com.example.sem4and3task.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    private final PaymentContext paymentContext;

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product p, Model model) {
        productService.addProduct(p);
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/pay")
    @ResponseBody
    public String makePayment(@RequestParam String method, @RequestParam double amount) {
        return paymentContext.processPayment(method, amount);
    }
}
