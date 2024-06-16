package com.baardana.products_service.dto.RequestDto;

import com.baardana.products_service.model.Product;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BrandRequestDto {

    String brandName;

    String description;

    String logoUrl;

    String websiteUrl;

    String country;

    boolean active;

    String metaTitle;

    String metaDescription;

    List<ProductRequestDto> products;
}
