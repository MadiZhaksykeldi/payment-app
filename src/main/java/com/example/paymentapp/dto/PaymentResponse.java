package com.example.paymentapp.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentResponse {
    private Long paymentId;
    private BigDecimal amount;
    private String currency;
    private String description;
    private String clientId;
    private String status;
}