package com.baardana.products_service.dto.ResponseDto;

import com.baardana.products_service.model.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {
    String productName;
    Integer sku;
    String categoryId;
    Date createdAt;

}
