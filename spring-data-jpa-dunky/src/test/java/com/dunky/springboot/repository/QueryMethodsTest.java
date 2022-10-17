package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod (){
        Product product = productRepository.findByName("Adidas red shoe");
        System.out.println("Product ID: " + product.getId() + "\nProduct name: " + product.getName() +
                "\nProduct description: " + product.getDescription());
    }
}
