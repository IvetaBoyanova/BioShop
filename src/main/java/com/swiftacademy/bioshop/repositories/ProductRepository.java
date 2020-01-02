package com.swiftacademy.bioshop.repositories;

import com.swiftacademy.bioshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByName(String name);
}
