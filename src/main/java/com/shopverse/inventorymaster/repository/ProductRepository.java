package com.shopverse.inventorymaster.repository;

import com.shopverse.inventorymaster.model.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice, Sort sort);
}
