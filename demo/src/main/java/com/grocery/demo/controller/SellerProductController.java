package com.grocery.demo.controller;

import com.grocery.demo.model.SellerProduct;
import com.grocery.demo.service.SellerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellerproducts")
@CrossOrigin(origins = "*")
public class SellerProductController {

    @Autowired
    private SellerProductService productService;

    @GetMapping
    public List<SellerProduct> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public SellerProduct add(@RequestBody SellerProduct product) {
        return productService.add(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody SellerProduct updated) {
        SellerProduct result = productService.update(id, updated);
        return (result != null) ? ResponseEntity.ok("Product updated") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted");
    }
}