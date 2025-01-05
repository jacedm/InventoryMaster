package com.shopverse.inventorymaster.model.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductResponse {
    public final String name;
    public final String description;
}
