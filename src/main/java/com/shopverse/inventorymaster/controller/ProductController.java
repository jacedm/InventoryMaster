package com.shopverse.inventorymaster.controller;

//        - `POST /api/products` — Создать товар.
//        - `GET /api/products` — Получить список всех товаров.
//        - `GET /api/products/{id}` — Получить информацию о товаре по ID.
//        - `PUT /api/products/{id}` — Обновить товар по ID.
//        - `DELETE /api/products/{id}` — Удалить товар по ID.

import com.shopverse.inventorymaster.model.dto.request.CreateUpdateProductRequest;
import com.shopverse.inventorymaster.model.dto.response.ProductResponse;
import com.shopverse.inventorymaster.model.entity.Product;
import com.shopverse.inventorymaster.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable @Positive(message = "ID must be a positive number") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductResponse createProduct(@Valid @RequestBody CreateUpdateProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable @Positive(message = "ID must be a positive number") Long id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable @Positive(message = "ID must be a positive number") Long id,
                              @Valid @RequestBody CreateUpdateProductRequest productRequest) {
        productService.updateProduct(id, productRequest);
    }
}
