package com.baardana.products_service.transformer;

import com.baardana.products_service.dto.RequestDto.BrandRequestDto;
import com.baardana.products_service.dto.ResponseDto.BrandResponseDto;
import com.baardana.products_service.model.Brand;
import jakarta.persistence.GeneratedValue;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class BrandTransformer {
    public static Brand brandRequestDtoToBrand(BrandRequestDto brandRequestDto){
        return Brand.builder()
                .brandName(brandRequestDto.getBrandName())
                .active(brandRequestDto.isActive())
                .country(brandRequestDto.getCountry())
                .description(brandRequestDto.getDescription())
                .metaDescription(brandRequestDto.getMetaDescription())
                .metaTitle(brandRequestDto.getMetaTitle())
                .logoUrl(brandRequestDto.getLogoUrl())
                .websiteUrl(brandRequestDto.getWebsiteUrl())
                .createdAt(new Date(Instant.now().toEpochMilli() ))
                .products(new ArrayList<>())
                .build();
    }

    public static BrandResponseDto brandToBrandResponseDto(Brand brand){
        return BrandResponseDto.builder()
                .brandName(brand.getBrandName())
                .active(brand.isActive())
                .country(brand.getCountry())
                .description(brand.getDescription())
                .metaDescription(brand.getMetaDescription())
                .metaTitle(brand.getMetaTitle())
                .logoUrl(brand.getLogoUrl())
                .websiteUrl(brand.getWebsiteUrl())
                .createdAt(brand.getCreatedAt())
                .build();
    }
}
