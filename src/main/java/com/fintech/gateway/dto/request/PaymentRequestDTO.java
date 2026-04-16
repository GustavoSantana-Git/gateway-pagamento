package com.fintech.gateway.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record PaymentRequestDTO(
        @NotBlank(message = "O ID do lojista é obrigatório")
        String merchantKey,

        @NotNull(message = "O valor da transação é obrigatório")
        @DecimalMin(value = "0.01", message = "O valor mínimo é 0.01")
        BigDecimal amount,

        @NotBlank(message = "A moeda é obrigatória (ex: BRL, USD)")
        @Size(min = 3, max = 3, message = "Use o código ISO de 3 dígitos (ex: BRL)")
        String currency,

        @NotBlank(message = "O método de pagamento é obrigatório")
        String paymentMethod,

        @NotBlank(message = "Número do cartão é obrigatório para este método")
        @Pattern(regexp = "\\d{16}", message = "O cartão deve conter 16 dígitos")
        String cardNumber,

        @NotBlank(message = "CVV é obrigatório")
        @Pattern(regexp = "\\d{3,4}", message = "CVV inválido")
        String cvv,

        @NotBlank(message = "Data de expiração é obrigatória")
        @Pattern(regexp = "(0[1-9]|1[0-2])/[0-9]{2}", message = "Use o formato MM/YY")
        String expiryDate,

        String description
) {}