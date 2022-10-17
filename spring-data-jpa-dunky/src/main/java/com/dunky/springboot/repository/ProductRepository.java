package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
     * Returns the found list of product entries whose name or description is given
     * as a method parameter.
     * If no product entries is found, this method returns an empty list.
     */
    public List<Product> findByNameOrDescription (String name, String Description);

    /**
     * Returns the found list of product entries whose name and description is given
     * as a method parameter.
     * If no product entries is found, this method returns an empty list.
     */
    public List<Product> findByNameAndDescriptionAndPrice (String name, String Description, BigDecimal price);

    /**
     * Returns the distinct product entry entries whose name is given
     * as a method parameter.
     * If no product entries is found, this method returns null.
     */
    public List<Product> findByPriceGreaterThan (BigDecimal price);

    /**
     * Returns the filtered product records that match
     * the given text.
     */
    public List<Product> findByNameContaining (String name);

    /**
     * Returns the product based on SQL LIKE condition
     * the given text.
     */
    public List<Product> findByNameLike (String name);

    /**
     * Returns the product whose price BETWEEN startPrice AND endPrice.
     *
     */
    public List<Product> findByPriceBetween (BigDecimal startPrice, BigDecimal endPrice);

    /**
     * Returns the products whose creation date lies BETWEEN startDate AND endDate.
     *
     */
    public List<Product> findByDateCreatedBetween (LocalDateTime startDate, LocalDateTime endDate);
}
