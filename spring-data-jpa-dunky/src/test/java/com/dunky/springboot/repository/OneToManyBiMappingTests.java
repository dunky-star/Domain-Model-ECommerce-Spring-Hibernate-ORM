package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Address;
import com.dunky.springboot.entity.Order;
import com.dunky.springboot.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyBiMappingTests {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // save order along with also save it's order items
    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("100ABCD");
        order.setStatus("In progress");

        // create order item 1
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(1L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("image1.png");
        order.getOrderItems().add(orderItem1);

        // create order item 2
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(2L).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("image2.png");
        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

        Address address = new Address();
        address.setCity("Kampala");
        address.setStreet("Najjera I");
        address.setState("Uganda");
        address.setCountry("Uganda");
        address.setZipCode("+256");

        order.setBillingAddress(address);
        
        orderRepository.save(order);
    }
}
