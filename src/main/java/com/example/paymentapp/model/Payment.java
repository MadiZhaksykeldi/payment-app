package com.example.paymentapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private BigDecimal amount;

    private String currency;

    private String description;

    private String clientId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}