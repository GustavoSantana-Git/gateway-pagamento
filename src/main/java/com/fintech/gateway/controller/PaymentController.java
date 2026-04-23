package com.fintech.gateway.controller;

import com.fintech.gateway.dto.request.PaymentRequestDTO;
import com.fintech.gateway.dto.response.PaymentResponseDTO;
import com.fintech.gateway.model.Transaction;
import com.fintech.gateway.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Tag(name = "Payments", description = "API para processamento de pagamentos")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @Operation(summary = "Processar um pagamento")
    public ResponseEntity<PaymentResponseDTO> processPayment(@Valid @RequestBody PaymentRequestDTO request) {
        Transaction transaction = paymentService.processPayment(request);
        PaymentResponseDTO response = new PaymentResponseDTO(
                transaction.getExternalId(),
                transaction.getStatus().name(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getPaymentMethod().name(),
                transaction.getCreatedAt()
        );
        return ResponseEntity.ok(response);
    }
}
