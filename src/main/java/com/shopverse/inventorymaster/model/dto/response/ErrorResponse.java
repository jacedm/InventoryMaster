package com.shopverse.inventorymaster.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Map;

@Getter
public class ErrorResponse {
    private final String errorMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> details;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorResponse(String errorMessage, Map<String, String> details) {
        this.errorMessage = errorMessage;
        this.details = details;
    }
}
