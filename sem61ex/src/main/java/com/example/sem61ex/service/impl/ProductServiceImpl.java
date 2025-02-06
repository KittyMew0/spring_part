package com.example.sem61ex.service.impl;

import com.example.sem61ex.aspect.TrackUserAction;
import com.example.sem61ex.model.Product;
import com.example.sem61ex.repository.ProductRepository;
import com.example.sem61ex.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @TrackUserAction
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    @TrackUserAction
    public Product updateProduct(Product product) {
        Product productById = getProductById(product.getId());

        productById.setName(product.getName());
        productById.setCount(product.getCount());
        productById.setQuantity(product.getQuantity());

        return productRepository.save(productById);
    }

    @Override
    @TrackUserAction
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @TrackUserAction
    public void deleteProduct(Long id) {
        Product productById = getProductById(id);
        productRepository.delete(productById);
    }
}
