package com.baardana.products_service.service;

import com.baardana.products_service.dto.RequestDto.BrandRequestDto;
import com.baardana.products_service.dto.RequestDto.ProductRequestDto;
import com.baardana.products_service.dto.ResponseDto.BrandResponseDto;
import com.baardana.products_service.dto.ResponseDto.ProductResponseDto;
import com.baardana.products_service.model.Brand;
import com.baardana.products_service.model.Product;
import com.baardana.products_service.repository.BrandRepository;
import com.baardana.products_service.transformer.BrandTransformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    ProductService productService;
    private static final Logger logger = LogManager.getLogger(BrandService.class);
    public BrandResponseDto addBrand(BrandRequestDto brandRequestDto) throws Exception {

        Brand brand = BrandTransformer.brandRequestDtoToBrand(brandRequestDto);
         logger.debug("debugger message");
        List<ProductRequestDto> products = brandRequestDto.getProducts();

        if (products != null && !products.isEmpty()) {
            for (ProductRequestDto productRequestDto : products) {
                Product product = productService.addProductInBrand(productRequestDto);
                brand.getProducts().add(product);
            }
        }

        Brand savedBrand = brandRepository.save(brand);
        return BrandTransformer.brandToBrandResponseDto(savedBrand);
    }
}
