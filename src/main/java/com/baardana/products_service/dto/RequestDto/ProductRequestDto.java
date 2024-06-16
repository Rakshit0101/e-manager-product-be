package com.baardana.products_service.dto.RequestDto;

import com.baardana.products_service.model.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductRequestDto {
    String productName;
    Integer sku;
    String imageURL;
    String categoryId;
    BigDecimal weight;
    BigDecimal length;
    BigDecimal width;
    BigDecimal height;
    boolean active;

}
