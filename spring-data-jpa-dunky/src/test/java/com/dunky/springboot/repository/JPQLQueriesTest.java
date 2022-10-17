package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJPQLNamedParam
                ("New Orlean Sneaker", "Best of class sneaker");

        System.out.println("Product ID: " + product.getId() + "\nProduct name: " + product.getName() +
                "\nProduct description: " + product.getDescription());
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLNamedParam
                ("New Orlean Sneaker", "Best of class sneaker");

        System.out.println("Product ID: " + product.getId() + "\nProduct name: " + product.getName() +
                "\nProduct description: " + product.getDescription());
    }
}
