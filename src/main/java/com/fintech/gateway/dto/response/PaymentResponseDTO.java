package com.fintech.gateway.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentResponseDTO(
        UUID externalId,
        String status,
        BigDecimal amount,
        String currency,
        String paymentMethod,
        LocalDateTime createdAt
) {}
