package com.baardana.products_service.service;

import com.baardana.products_service.dto.RequestDto.ProductCategoryRequestDto;
import com.baardana.products_service.dto.ResponseDto.ProductCategoryResponseDto;
import com.baardana.products_service.model.ProductCategory;
import com.baardana.products_service.repository.ProductCategoryRepository;
import com.baardana.products_service.transformer.ProductCategoryTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    public ProductCategoryResponseDto addProductCategory
            (ProductCategoryRequestDto productCategoryRequestDto) throws Exception {

        ProductCategory productCategory = ProductCategoryTransformer
                .productCategoryRequestDtoToProductCategory(productCategoryRequestDto);

        ProductCategory savedProductCategory =  productCategoryRepository.save(productCategory);

        return  ProductCategoryTransformer
                .productCategoryToProductCategoryResponseDto(savedProductCategory);
    }
}
