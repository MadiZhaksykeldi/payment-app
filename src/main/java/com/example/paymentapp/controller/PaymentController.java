package com.example.paymentapp.controller;

import com.example.paymentapp.dto.PaymentRequest;
import com.example.paymentapp.dto.PaymentResponse;
import com.example.paymentapp.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse createPayment(@Valid @RequestBody PaymentRequest request) {
        return paymentService.createPayment(request);
    }

    @GetMapping("/payments/{paymentId}")
    public PaymentResponse getPayment(@PathVariable Long paymentId) {
        return paymentService.getPayment(paymentId);
    }

    @PostMapping("/payments/{paymentId}/confirm")
    public PaymentResponse confirmPayment(@PathVariable Long paymentId) {
        return paymentService.confirmPayment(paymentId);
    }

    @PostMapping("/payments/{paymentId}/cancel")
    public PaymentResponse cancelPayment(@PathVariable Long paymentId) {
        return paymentService.cancelPayment(paymentId);
    }

    @GetMapping("/clients/{clientId}/payments")
    public List<PaymentResponse> getClientPayments(@PathVariable String clientId) {
        return paymentService.getClientPayments(clientId);
    }
}