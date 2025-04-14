package com.grocery.demo.service;

import com.grocery.demo.model.SellerProduct;
import com.grocery.demo.repository.SellerProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerProductService {

    @Autowired
    private SellerProductRepository productRepo;

    public List<SellerProduct> getAll() {
        return productRepo.findAll();
    }

    public SellerProduct add(SellerProduct product) {
        return productRepo.save(product);
    }

    public SellerProduct update(Long id, SellerProduct updated) {
        return productRepo.findById(id).map(p -> {
            p.setName(updated.getName());
            p.setCategory(updated.getCategory());
            p.setPrice(updated.getPrice());
            return productRepo.save(p);
        }).orElse(null);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }
}