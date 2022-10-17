package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Returns the found product entry by using its name as search criteria.
     * If no product entry is found, this method returns null.
     */
    public Product findByName (String name);

    /**
     * Returns an Optional which contains the found product
     * entry by using its id as search criteria.
     * If no product entry is found, this method returns an empty Optional.
     */
    public Optional<Product> findById(Long id);


    /**
     * Returns the found list of product entries whose title or description is given
     * as a method parameter.
     * If no product entries is found, this method returns an empty list.
     */
    List<Product> findByNameOrDescription (String name, String Description);

}
