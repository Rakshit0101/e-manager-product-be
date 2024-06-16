package com.baardana.products_service.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.relational.core.sql.In;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id", nullable = false)
    String productId;

    @Column(name = "product_name", nullable = false)
    String productName;

    @Column(name = "category_id", nullable = false)
    String categoryId;

    @Min(0)
    @Max(10000)
    @Column(name = "sku", nullable = false)
    Integer sku;

    @Column(name = "weight", precision = 5, scale = 2)
    BigDecimal weight;

    @Column(name = "length", precision = 5, scale = 2)
    BigDecimal length;

    @Column(name = "width", precision = 5, scale = 2)
    BigDecimal width;

    @Column(name = "height", precision = 5, scale = 2)
    BigDecimal height;

    @Column(name = "active",columnDefinition = "boolean default true")
    boolean active;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;

    @Column(name = "updated_at", nullable = true, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    Date updatedAt;

    @Column(name = "sys_modified_at", columnDefinition = "DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    Date sysModifiedAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    ProductCategory category;

    @ManyToMany(mappedBy = "products",cascade = CascadeType.PERSIST)
    List<Brand> brands ;


//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<Image> images;

}
