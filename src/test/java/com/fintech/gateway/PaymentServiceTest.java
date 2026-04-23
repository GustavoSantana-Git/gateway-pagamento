package com.fintech.gateway;

import com.fintech.gateway.dto.request.PaymentRequestDTO;
import com.fintech.gateway.model.Merchant;
import com.fintech.gateway.model.Transaction;
import com.fintech.gateway.repository.MerchantRepository;
import com.fintech.gateway.repository.TransactionRepository;
import com.fintech.gateway.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @MockBean
    private MerchantRepository merchantRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    void shouldProcessPaymentSuccessfully() {
        // Given
        Merchant merchant = new Merchant();
        merchant.setId(1L);
        merchant.setApiKey("sk_test_517ghj678");
        merchant.setStatus(Merchant.MerchantStatus.ACTIVE);

        when(merchantRepository.findByApiKey("sk_test_517ghj678")).thenReturn(Optional.of(merchant));

        Transaction savedTransaction = new Transaction();
        savedTransaction.setId(1L);
        savedTransaction.setExternalId(java.util.UUID.randomUUID());
        savedTransaction.setStatus(Transaction.TransactionStatus.APPROVED);
        when(transactionRepository.save(any(Transaction.class))).thenReturn(savedTransaction);

        PaymentRequestDTO request = new PaymentRequestDTO(
                "sk_test_517ghj678",
                BigDecimal.valueOf(100.00),
                "BRL",
                "CREDIT_CARD",
                "4111111111111111",
                "123",
                "12/25",
                "Test payment"
        );

        // When
        Transaction result = paymentService.processPayment(request);

        // Then
        assertThat(result.getStatus()).isEqualTo(Transaction.TransactionStatus.APPROVED);
    }
}
