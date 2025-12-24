package com.ranjana.springboot.localMVP.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record SubscriptionRequest(
        @NotBlank String city,
        @NotNull @Min(0) Integer minPrice,
        @NotNull Integer maxPrice,
        @NotNull @Min(0) Integer minBedrooms
) {}
