package com.example.sem61ex.service;

import com.example.sem61ex.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Product product);

    Product createProduct(Product product);

    void deleteProduct(Long id);
}
