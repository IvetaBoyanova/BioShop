package com.swiftacademy.bioshop.controllers;


import com.swiftacademy.bioshop.DTO.ProductDto;
import com.swiftacademy.bioshop.DTO.UserLoginDto;
import com.swiftacademy.bioshop.model.Product;
import com.swiftacademy.bioshop.model.User;
import com.swiftacademy.bioshop.repositories.ProductRepository;
import com.swiftacademy.bioshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/all")
    private List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    private Product getProductDetails(@PathVariable("id") Integer productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (!product.isPresent()) {
            throw new IllegalArgumentException(String.format("There is no Product with id: %s", productId));
        }

        return product.get();
    }
}
