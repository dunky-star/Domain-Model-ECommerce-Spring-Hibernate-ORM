package com.dunky.springboot.service;

import com.dunky.springboot.dto.OrderRequest;
import com.dunky.springboot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
