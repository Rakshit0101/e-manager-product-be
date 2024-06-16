package com.baardana.products_service.service;

import com.baardana.products_service.dto.RequestDto.ProductRequestDto;
import com.baardana.products_service.dto.ResponseDto.ProductResponseDto;
import com.baardana.products_service.model.Product;
import com.baardana.products_service.model.ProductCategory;
import com.baardana.products_service.repository.ProductCategoryRepository;
import com.baardana.products_service.repository.ProductRepository;
import com.baardana.products_service.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws Exception {

        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(productRequestDto.getCategoryId());

        if (productCategoryOptional.isEmpty()) {
            throw new Exception("ProductCategory not found with ID: " + productRequestDto.getCategoryId());
        }

        ProductCategory productCategory = productCategoryOptional.get();

        Product product = ProductTransformer.productRequestDtoToProduct(productRequestDto);
        product.setCategory(productCategory);

        Product savedProduct = productRepository.save(product);

        return ProductTransformer.producToProductResponseDto(savedProduct);
    }
    public Product addProductInBrand(ProductRequestDto productRequestDto) throws Exception {

        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(productRequestDto.getCategoryId());

        if (productCategoryOptional.isEmpty()) {
            throw new Exception("ProductCategory not found with ID: " + productRequestDto.getCategoryId());
        }

        ProductCategory productCategory = productCategoryOptional.get();

        Product product = ProductTransformer.productRequestDtoToProduct(productRequestDto);
        product.setCategory(productCategory);

        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }
    public List<ProductResponseDto> getAllProductsByCategoryId(String categoryId) {
        // Fetch all products by category ID
        List<Product> products = productRepository.findByCategoryId(categoryId);

        // Convert the list of Product entities to a list of ProductResponseDto objects
        List<ProductResponseDto> productResponseDtos = products.stream()
                .map(ProductTransformer::producToProductResponseDto)
                .collect(Collectors.toList());

        return productResponseDtos;
    }
}
