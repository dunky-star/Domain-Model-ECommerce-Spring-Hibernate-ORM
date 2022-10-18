package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NamedNativeQueryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedNativeSQLMethod(){
        Product product = productRepository.findByDescription("Best sneaker in the market");
        System.out.println("Product ID: " + product.getId() + "\nProduct name: " + product.getName() +
                "\nProduct description: " + product.getDescription());
    }
}
