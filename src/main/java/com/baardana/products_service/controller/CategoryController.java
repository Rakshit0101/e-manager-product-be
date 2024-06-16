package com.baardana.products_service.controller;

import com.baardana.products_service.dto.RequestDto.ProductCategoryRequestDto;
import com.baardana.products_service.dto.ResponseDto.ProductCategoryResponseDto;
import com.baardana.products_service.dto.ResponseDto.ProductResponseDto;
import com.baardana.products_service.service.ProductCategoryService;
import com.baardana.products_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    ProductService productService;
    @PostMapping("/addProductCategory")
    public ResponseEntity addCategory(@RequestBody ProductCategoryRequestDto productCategoryRequestDto){
        try{
            ProductCategoryResponseDto productCategoryResponseDto = productCategoryService.
                    addProductCategory(productCategoryRequestDto);

            return new ResponseEntity(productCategoryResponseDto, HttpStatus.CREATED);

        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getProductsByCategoryId/{categoryId}")
    public ResponseEntity getAllProductsByCategoryId(@PathVariable String categoryId) {
        try {
            List<ProductResponseDto> products = productService.getAllProductsByCategoryId(categoryId);
            return new ResponseEntity(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
