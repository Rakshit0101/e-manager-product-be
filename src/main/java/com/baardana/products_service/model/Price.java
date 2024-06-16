//package com.baardana.products_service.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.format.annotation.DateTimeFormat;
//
//
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Table(name = "price")
//public class Price {
//    @Id
//    @Column(name = "price_id", nullable = false)
//    String priceId;
//
//    @Column(name = "product_id", nullable = false)
//    String productId;
//
//    @Column(name = "variant_id")
//    String variantId;
//
//    @Column(name = "price", nullable = false, precision = 10, scale = 2)
//    BigDecimal price;
//
//    @Column(name = "sale_price", precision = 10, scale = 2)
//    BigDecimal salePrice;
//
//    @Column(name = "currency", nullable = false)
//    String currency;
//
//    @Column(name = "start_date")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    Date startDate;
//
//    @Column(name = "end_date")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    Date endDate;
//
//    @Column(name = "created_at", nullable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    Date createdAt;
//
//    @Column(name = "updated_at", columnDefinition = "datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    Date updatedAt;
//
//    @Column(name = "sys_modified_at", columnDefinition = "datetime default null on update CURRENT_TIMESTAMP")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    Date sysModifiedAt;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
//    private Product product;
//
//    @ManyToOne
//    @JoinColumn(name = "variant_id", referencedColumnName = "product_variant_id", insertable = false, updatable = false)
//    private ProductVariant variant;
//}
