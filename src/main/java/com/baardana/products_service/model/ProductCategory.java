package com.baardana.products_service.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id", nullable = false)
    String categoryId;

    @Column(name = "category_name", nullable = false)
    String categoryName;

    @Column(name = "description", columnDefinition = "text")
    String description;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;

    @Column(name = "updated_at", nullable = true, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    Date updatedAt;

    @Column(name = "sys_modified_at", columnDefinition = "DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    Date sysModifiedAt;

    @Column(name = "active",columnDefinition = "boolean default true")
    boolean active;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Product> products;


}
