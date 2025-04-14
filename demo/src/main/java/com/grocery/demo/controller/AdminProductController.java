package com.grocery.demo.controller;

import com.grocery.demo.model.AdminProduct;
import com.grocery.demo.service.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adminproducts")
@CrossOrigin(origins = "*")
public class AdminProductController {

    @Autowired
    private AdminProductService productService;

    @GetMapping
    public List<AdminProduct> getAll() {
        return productService.getAllProducts();
    }

    @PostMapping
    public AdminProduct create(@RequestBody AdminProduct product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody AdminProduct updated) {
        AdminProduct result = productService.updateProduct(id, updated);
        return (result != null) ? ResponseEntity.ok("Product updated") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted");
    }
}