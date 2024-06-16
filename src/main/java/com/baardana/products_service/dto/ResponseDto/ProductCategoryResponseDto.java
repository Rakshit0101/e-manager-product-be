package com.baardana.products_service.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCategoryResponseDto {
    String categoryName;
    String description;
    boolean active;
    Date createdAt;
}
