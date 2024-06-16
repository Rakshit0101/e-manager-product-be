package com.baardana.products_service.transformer;

import com.baardana.products_service.dto.RequestDto.ProductCategoryRequestDto;
import com.baardana.products_service.dto.ResponseDto.ProductCategoryResponseDto;
import com.baardana.products_service.model.ProductCategory;

import java.time.Instant;
import java.util.Date;

public class ProductCategoryTransformer {
    public static ProductCategory productCategoryRequestDtoToProductCategory
            (ProductCategoryRequestDto productCategoryRequestDto){
        return ProductCategory.builder()
                .categoryName(productCategoryRequestDto.getCategoryName())
                .description(productCategoryRequestDto.getDescription())
                .active(productCategoryRequestDto.isActive())
                .createdAt(new Date(Instant.now().toEpochMilli() ))
                .build();
    }
    public static ProductCategoryResponseDto productCategoryToProductCategoryResponseDto
            (ProductCategory productCategory){
        return ProductCategoryResponseDto.builder()
                .categoryName(productCategory.getCategoryName())
                .description(productCategory.getDescription())
                .active(productCategory.isActive())
                .createdAt(productCategory.getCreatedAt())
                .build();

    }
}
