package com.baardana.products_service.repository;

import com.baardana.products_service.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,String> {
}
