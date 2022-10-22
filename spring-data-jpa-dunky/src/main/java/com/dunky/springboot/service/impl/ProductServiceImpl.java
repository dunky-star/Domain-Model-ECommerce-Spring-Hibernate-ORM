package com.dunky.springboot.service.impl;

import com.dunky.springboot.entity.Product;
import com.dunky.springboot.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> searchProducts(String query) {
        return null;
    }
}
