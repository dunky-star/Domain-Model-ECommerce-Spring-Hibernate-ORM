package com.dunky.springboot.service;

import com.dunky.springboot.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
