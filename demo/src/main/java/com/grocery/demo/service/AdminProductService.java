package com.grocery.demo.service;

import com.grocery.demo.model.AdminProduct;
import com.grocery.demo.repository.AdminProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProductService {

    @Autowired
    private AdminProductRepository productRepository;

    public List<AdminProduct> getAllProducts() {
        return productRepository.findAll();
    }

    public AdminProduct addProduct(AdminProduct product) {
        return productRepository.save(product);
    }

    public AdminProduct updateProduct(Long id, AdminProduct updatedProduct) {
        return productRepository.findById(id).map(p -> {
            p.setName(updatedProduct.getName());
            p.setCategory(updatedProduct.getCategory());
            p.setPrice(updatedProduct.getPrice());
            return productRepository.save(p);
        }).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}