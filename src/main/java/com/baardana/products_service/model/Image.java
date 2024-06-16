//package com.baardana.products_service.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.format.annotation.DateTimeFormat;
//
//
//import java.util.Date;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Table(name = "image")
//public class Image {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "image_id", nullable = false)
//    String imageId;
//
//    @Column(name = "product_id", nullable = false)
//    String productId;
//
//    @Column(name = "image_url", nullable = false, length = 2048)
//    String imageUrl;
//
//    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
//    @Temporal(TemporalType.TIMESTAMP)
//    Date createdAt;
//
//    @Column(name = "updated_at", nullable = true, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//    @Temporal(TemporalType.TIMESTAMP)
//    Date updatedAt;
//
//    @Column(name = "sys_modified_at", columnDefinition = "DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
//    @Temporal(TemporalType.TIMESTAMP)
//    Date sysModifiedAt;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
//    Product product;
//}
