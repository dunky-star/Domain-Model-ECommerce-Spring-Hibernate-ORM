package com.dunky.springboot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
    }
}
