package com.example.sem4and3task.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import com.example.sem4and3task.model.Product;
import com.example.sem4and3task.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

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
}
