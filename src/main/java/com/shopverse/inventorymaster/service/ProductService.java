package com.shopverse.inventorymaster.service;

import com.shopverse.inventorymaster.exception.ProductNotFoundException;
import com.shopverse.inventorymaster.model.dto.request.CreateUpdateProductRequest;
import com.shopverse.inventorymaster.model.dto.response.ProductResponse;
import com.shopverse.inventorymaster.model.entity.Product;
import com.shopverse.inventorymaster.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product not found")
        );
    }

    public ProductResponse createProduct(CreateUpdateProductRequest productRequest) {

        Product savedProduct = productRepository.save(
                Product.builder()
                        .name(productRequest.name())
                        .description(productRequest.description())
                        .price(productRequest.price())
                        .quantity(productRequest.quantity())
                        .build()
        );

        return ProductResponse.builder()
                .name(savedProduct.getName())
                .description(savedProduct.getDescription())
                .build();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, CreateUpdateProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product not found")
        );

        productRepository.save(
                product.toBuilder()
                        .name(productRequest.name())
                        .description(productRequest.description())
                        .price(productRequest.price())
                        .quantity(productRequest.quantity())
                        .build()
        );
    }

    public List<Product> getFilteredProducts(BigDecimal minPrice, BigDecimal maxPrice, Sort sort) {
        return productRepository.findAllByPriceBetween(minPrice, maxPrice, sort);
    }
}
