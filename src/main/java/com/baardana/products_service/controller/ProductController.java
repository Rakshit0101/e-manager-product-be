package com.baardana.products_service.controller;

import com.baardana.products_service.dto.RequestDto.ProductCategoryRequestDto;
import com.baardana.products_service.dto.RequestDto.ProductRequestDto;
import com.baardana.products_service.dto.ResponseDto.ProductCategoryResponseDto;
import com.baardana.products_service.dto.ResponseDto.ProductResponseDto;
import com.baardana.products_service.service.ProductCategoryService;
import com.baardana.products_service.service.ProductService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController{
    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){

        try{
            ProductResponseDto productResponseDto = productService.addProduct(productRequestDto);
            return new ResponseEntity(productResponseDto, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}