package com.grocery.demo.repository;

import com.grocery.demo.model.SellerProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerProductRepository extends JpaRepository<SellerProduct, Long> {}