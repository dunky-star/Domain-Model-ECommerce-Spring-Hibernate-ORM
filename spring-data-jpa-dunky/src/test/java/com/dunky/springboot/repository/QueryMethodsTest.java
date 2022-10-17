package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod (){
        Product product = productRepository.findByName("Converse shoe");
        System.out.println("Product ID: " + product.getId() + "\nProduct name: " + product.getName() +
                "\nProduct description: " + product.getDescription());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(10L).get();
        System.out.println("Product ID: " + product.getId() + "\nProduct name: " + product.getName() +
                "\nProduct description: " + product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product>  products = productRepository.findByNameOrDescription("Converse shoe - red",
                "Best red Converse in the market");
        products.forEach((p) -> {System.out.println("Product ID: " + p.getId() + "\nProduct name: " + p.getName() +
                "\nProduct description: " + p.getDescription());});
    }

    @Test
    void findByNameAndDescriptionAndPriceMethod(){
        List<Product>  products = productRepository.findByNameAndDescriptionAndPrice("Converse shoe - red",
                "Best red Converse in the market", BigDecimal.valueOf(800.00));
        products.forEach((p) -> {System.out.println("Product ID: " + p.getId() + "\nProduct name: " + p.getName() +
                "\nProduct description: " + p.getDescription() + " \nPrice: " + p.getPrice() + " \n");});
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product>  products = productRepository.findByPriceGreaterThan(BigDecimal.valueOf(200));
        products.forEach((p) -> {System.out.println("Product ID: " + p.getId() + "\nProduct name: " + p.getName() +
                "\nProduct description: " + p.getDescription() + " \nPrice: " + p.getPrice() + " \n");});
    }

 }

