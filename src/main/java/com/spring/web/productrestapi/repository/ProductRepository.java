package com.spring.web.productrestapi.repository;

import com.spring.web.productrestapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
