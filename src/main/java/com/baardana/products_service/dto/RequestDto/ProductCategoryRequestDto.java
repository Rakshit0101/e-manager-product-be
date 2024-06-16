package com.baardana.products_service.dto.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder
public class ProductCategoryRequestDto {
    String categoryName;
    String description;
    boolean active;
}
