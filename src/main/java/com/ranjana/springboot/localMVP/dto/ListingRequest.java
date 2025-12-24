package com.ranjana.springboot.localMVP.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ListingRequest(
        @NotBlank(message = "City is Required")
        String city,

        @NotNull(message = "Price is Required")
        @Min(value = 0,message = "value must be >= 0")
        Integer price,

        @NotNull(message = "Bedrooms is required")
        @Min(value = 0, message = "Bedrooms must be >= 0")
        Integer bedrooms
) {}
