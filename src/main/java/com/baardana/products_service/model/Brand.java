package com.baardana.products_service.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "brand")
public class Brand {
    @Id
    @Column(name = "brand_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    String brandId;

    @Column(name = "brand_name", nullable = false)
    String brandName;

    @Column(name = "description", columnDefinition = "text")
    String description;

    @Column(name = "logo_url", length = 2048)
    String logoUrl;

    @Column(name = "website_url", length = 2048)
    String websiteUrl;

    @Column(name = "country", length = 255)
    String country;

    @Column(name = "active", columnDefinition = "boolean default true")
    boolean active;

    @Column(name = "meta_title")
    String metaTitle;

    @Column(name = "meta_description", columnDefinition = "text")
    String metaDescription;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;

    @Column(name = "updated_at", nullable = true, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    Date updatedAt;

    @Column(name = "sys_modified_at", columnDefinition = "DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    Date sysModifiedAt;

    @ManyToMany(cascade = { CascadeType.PERSIST})
    @JoinTable(
            name = "product_brand_junction",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> products = new ArrayList<>();

}
