package com.example.paymentapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    @Positive
    private BigDecimal amount;

    @NotBlank
    @Pattern(regexp = "KZT|USD|EUR|RUB|CNY")
    private String currency;

    @NotBlank
    private String description;

    @NotBlank
    private String clientId;
}