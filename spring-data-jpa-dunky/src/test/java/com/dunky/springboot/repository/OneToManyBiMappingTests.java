package com.dunky.springboot.repository;

import com.dunky.springboot.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyBiMappingTests {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    // save order along with also save it's order items
    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("100ABCDE");
        order.setStatus("In progress");

        // create order item 1
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(3L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("image1.png");
        orderItem1.setOrder(order);
        order.getOrderItems().add(orderItem1);

        // create order item 2
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(4L).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("image2.png");
        orderItem2.setOrder(order);
        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

        Address address = new Address();
        address.setCity("Kampala");
        address.setStreet("Najjera I");
        address.setState("Uganda");
        address.setCountry("Uganda");
        address.setZipCode("256");

        order.setBillingAddress(address);
        address.setOrder(order);
        orderRepository.save(order);
    }

    @Test
    void saveProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("Books");
        productCategory.setCategoryDescription("Books description");

        Product product1 = new Product();
        product1.setName("Core Java");
        product1.setDescription("Best Core Java Book");
        product1.setPrice(new BigDecimal(1000));
        product1.setImageUrl("image_java1.png");
        product1.setSku("ABCDJava1");
        product1.setActive(true);
        product1.setCategory(productCategory);
        productCategory.getProducts().add(product1);

        Product product2 = new Product();
        product2.setName("Effective Java");
        product2.setDescription("Trending Java development topics.");
        product2.setPrice(new BigDecimal(2000));
        product2.setImageUrl("image_java2.png");
        product2.setSku("ABCDJava2");
        product2.setActive(true);
        product2.setCategory(productCategory);
        productCategory.getProducts().add(product2);

        productCategoryRepository.save(productCategory);
    }


    @Test
    @Transactional
    void fetchProductCategory(){
        ProductCategory category = productCategoryRepository.findById(2L).get();
        System.out.println(category.getProducts());
    }
}
