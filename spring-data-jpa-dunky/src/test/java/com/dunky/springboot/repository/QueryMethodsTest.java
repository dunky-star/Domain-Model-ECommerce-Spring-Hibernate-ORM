package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @Test
    void findByNameContainingMethod(){
        List<Product>  products = productRepository.findByNameContaining("shoe");
        products.forEach((p)->{
            System.out.println("Product ID: " + p.getId() + "\nProduct name: " + p.getName() +
                    "\nProduct description: " + p.getDescription() + " \nPrice: " + p.getPrice() + " \n");
        });
    }

    @Test
    void findByNameLikeMethod(){
        List<Product>  products = productRepository.findByNameLike("shoe");
        products.forEach((p)->{
            System.out.println("Product ID: " + p.getId() + "\nProduct name: " + p.getName() +
                    "\nProduct description: " + p.getDescription() + " \nPrice: " + p.getPrice() + " \n");
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product>  products = productRepository.findByPriceBetween(new BigDecimal(100.00),
                new BigDecimal(400.00));
        products.forEach((p)->{
            System.out.println("Product ID: " + p.getId() + "\nProduct name: " + p.getName() +
                    "\nProduct description: " + p.getDescription() + " \nPrice: " + p.getPrice() + " \n");
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        // Start date
        LocalDateTime startDate = LocalDateTime.of(2022, 10, 13, 19, 39, 48 );
        // End date
        LocalDateTime endDate = LocalDateTime.of(2022, 10, 16, 12, 18, 03 );
        List<Product>  products = productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach((p)->{
            System.out.println("Product ID: " + p.getId() + "\nProduct name: " + p.getName() +
                    "\nProduct description: " + p.getDescription() + " \nPrice: " + p.getPrice() + " \n");
        });
    }

    @Test
    void findFirst3ByOrderByNameAscMethod(){
        List<Product>  products = productRepository.findFirst3ByOrderByNameAsc();

        products.forEach((p)->{
            System.out.println("Product ID: " + p.getId() + "\nProduct name: " + p.getName() +
                    "\nProduct description: " + p.getDescription() + " \nPrice: " + p.getPrice() + " \n");
        });
    }

 }

