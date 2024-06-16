package com.baardana.products_service.transformer;

import com.baardana.products_service.dto.RequestDto.ProductRequestDto;
import com.baardana.products_service.dto.ResponseDto.ProductResponseDto;
import com.baardana.products_service.model.Product;
import com.baardana.products_service.model.ProductCategory;

import java.time.Instant;
import java.util.Date;

public class ProductTransformer {
    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto){

        return Product.builder()
                .productName(productRequestDto.getProductName())
                .width(productRequestDto.getWidth())
                .height(productRequestDto.getHeight())
                .categoryId(productRequestDto.getCategoryId())
                .length(productRequestDto.getLength())
                .weight(productRequestDto.getWeight())
                .sku(productRequestDto.getSku())
                .createdAt(new Date(Instant.now().toEpochMilli() ))
                .build();
    }

    public static ProductResponseDto producToProductResponseDto(Product product){

        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .categoryId(product.getCategoryId())
                .sku(product.getSku())
                .createdAt(product.getCreatedAt())
                .build();

    }
}
