package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void pagination(){
        int pageNo = 0;
        int pageSize = 5;

        // Create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        // findAll method and pass pageable instance.
        Page<Product> page = productRepository.findAll(pageable);
        List<Product> products = page.getContent();

        // Printing list of products
        products.forEach((p)->{
            System.out.println("Product ID: " + p.getId() + "\nProduct name: " + p.getName() +
                    "\nProduct description: " + p.getDescription() + " \nPrice: " + p.getPrice() + " \n");
        });
    }
}
