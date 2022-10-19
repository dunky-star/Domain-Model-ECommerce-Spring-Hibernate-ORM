package com.dunky.springboot.repository;

import com.dunky.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        // Create product
        Product product = new Product();
        product.setName("Sneaker shoe");
        product.setDescription("Best sneaker in the market");
        product.setSku("300ABCG");
        product.setPrice(new BigDecimal(300));
        product.setActive(true);
        product.setImageUrl("/home/sneaker.png");

        // Save product
        Product savedProduct = productRepository.save(product);

        // Display product info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }

    @Test
    void updateUsingSaveMethod(){
        // find or retrieve an entity by id
         Long id = 1L;
         Product product = productRepository.findById(id).get();
        // update entity information
        product.setName("New Orlean Sneaker");
        product.setDescription("Best of class sneaker");

        // save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        // find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

    }

    @Test
    void saveAllMethod(){
        // Create product
        Product product2 = new Product();
        product2.setName("Adidas red shoe");
        product2.setDescription("Best red Adidas in Kampala");
        product2.setSku("700ABCDE");
        product2.setPrice(new BigDecimal(600));
        product2.setActive(true);
        product2.setImageUrl("/home/adidas3.png");

        // Create product
        Product product3 = new Product();
        product3.setName("Converse shoe - red");
        product3.setDescription("Best red Converse in the market");
        product3.setSku("800ABCD");
        product3.setPrice(new BigDecimal(800));
        product3.setActive(true);
        product3.setImageUrl("/home/converse3.png");

        productRepository.saveAll(List.of(product2, product3));

    }

    @Test
    void findAllMethod(){
        // Implementing sorting by multiple fields and pagination.
        String sortByName = "name";
        String sortByDesc = "description";
        String sortDir = "desc";
        int pageNo = 0;
        int pageSize = 5;

        Sort sortedName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortByName).ascending() : Sort.by(sortByName).descending();

        Sort sortedDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortByDesc).ascending() : Sort.by(sortByDesc).descending();

        Sort goupBySort = sortedName.and(sortedDescription);

        // Create pageable object
        Pageable pageableFindAll = PageRequest.of(pageNo, pageSize, goupBySort);

        Page<Product> sortedProducts = productRepository.findAll(pageableFindAll);

        List<Product>  products = sortedProducts.getContent();
        products.forEach((p) -> {
            System.out.println("product: " + p.getName() + " -> Price: " + p.getPrice());
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id = 7L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        // Find an entity by Id
        Long id = 6L;
        Product product = productRepository.findById(id).get();
        // delete (entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
        productRepository.deleteAll();
    }

    @Test
    void existByIdMethod(){
        Long id = 13L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }
}