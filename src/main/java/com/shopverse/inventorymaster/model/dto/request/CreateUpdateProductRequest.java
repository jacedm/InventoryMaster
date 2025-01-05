package com.shopverse.inventorymaster.model.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateUpdateProductRequest(

        @NotNull(message = "Name is required")
        @NotBlank(message = "Need a name")
        @Size(min = 3, max = 100, message = "Name cannot exceed 100 characters and have less than 3 characters")
        String name,

        @NotNull(message = "Description is required")
        @Size(max = 255, message = "Description cannot exceed 255 characters")
        String description,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.01", message = "Price must be greater than 0")
        BigDecimal price,

        @NotNull(message = "Quantity is required")
        @Min(value = 0, message = "Quantity cannot be negative")
        Integer quantity
) {
}
