package com.dunky.springboot.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter  // Lombok - for boiler plate removal.
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity  // To specify this class as JPA entity.
@NamedNativeQuery(
        name="Product.findByDescription",
        query = "SELECT * FROM products p WHERE p.description = :description LIMIT 5",
        resultClass=Product.class
)
@Table(
        name = "products",
        schema = "ecommercespringdatajpa",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "sku"
                )
        }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="sku", nullable = false)
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory category;
}
