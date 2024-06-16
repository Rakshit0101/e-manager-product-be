package com.baardana.products_service.repository;

import com.baardana.products_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface ProductRepository extends JpaRepository<Product, String> {

        List<Product> findByCategoryId(String categoryId);
    }

