package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        // Create product
        Product product = new Product();
        product.setName("Sneaker shoe");
        product.setDescription("Best sneaker in the market");
        product.setSku("200ABC");
        product.setPrice(new BigDecimal(300));
        product.setActive(true);
        product.setImageUrl("/home/sneaker.png");

        // Save product
        Product savedProduct = productRepository.save(product);

        // Display product info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }
}