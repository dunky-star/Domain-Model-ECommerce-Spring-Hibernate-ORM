package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

        // Total pages
        int totalPages = page.getTotalPages();

        // Total element
        long totalElements = page.getTotalElements();

        // Number of elements
        int numberOfElements = page.getNumberOfElements();

        // Size
        int size = page.getSize();

        // Last
        boolean isLast = page.isLast();

        // First
        boolean isFirst = page.isFirst();

        System.out.println("Total page -> " + totalPages);
        System.out.println("Total elements -> " + totalElements);
        System.out.println("Number of elements -> " + numberOfElements);
        System.out.println("Page size -> " + size);
        System.out.println("is last page? -> " + isLast);
        System.out.println("is first page? -> " + isFirst);
    }

    @Test
    void sorting(){
        // Sorting implemented
        String sortBy = "price";
        String sortDir = "desc";

        Sort sortObj = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        List<Product> sortedProducts = productRepository.findAll(sortObj);
        sortedProducts.forEach((p) -> {
            System.out.println("product: " + p.getName() + " -> Price: " + p.getPrice());
        });
    }

    @Test
    void paginationAndSorting(){
        // Sorting implemented
        String sortBy = "price";
        String sortDir = "desc";
        int pageNo = 0;
        int pageSize = 5;

        // Create sorting object
        Sort sortObj = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // Create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sortObj);

        Page<Product> sortedProducts = productRepository.findAll(pageable);

        List<Product>  products = sortedProducts.getContent();
        products.forEach((p) -> {
            System.out.println("product: " + p.getName() + " -> Price: " + p.getPrice());
        });

    }
}
