package com.baardana.products_service.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BrandResponseDto {
    String brandName;

    String description;

    String logoUrl;

    String websiteUrl;

    String country;

    boolean active;

    String metaTitle;

    String metaDescription;

    Date createdAt;
}
