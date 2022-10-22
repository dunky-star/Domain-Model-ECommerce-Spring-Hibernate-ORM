package com.dunky.springboot.dto;

import com.dunky.springboot.entity.Order;
import com.dunky.springboot.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}