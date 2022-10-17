package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * @param name
     * @return
     * Returns the found product entry by using its name as search criteria.
     * If no product entry is found, this method returns null.
     */
    public Product findByName (String name);

}
