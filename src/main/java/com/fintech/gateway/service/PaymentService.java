package com.fintech.gateway.service;

import com.fintech.gateway.dto.request.PaymentRequestDTO;
import com.fintech.gateway.model.Merchant;
import com.fintech.gateway.model.Transaction;
import com.fintech.gateway.repository.MerchantRepository;
import com.fintech.gateway.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final MerchantRepository merchantRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public Transaction processPayment(PaymentRequestDTO request) {
        // Validate merchant
        Optional<Merchant> merchantOpt = merchantRepository.findByApiKey(request.merchantKey());
        if (merchantOpt.isEmpty() || merchantOpt.get().getStatus() != Merchant.MerchantStatus.ACTIVE) {
            throw new IllegalArgumentException("Merchant inválido ou inativo");
        }
        Merchant merchant = merchantOpt.get();

        // Create transaction
        Transaction transaction = new Transaction();
        transaction.setMerchant(merchant);
        transaction.setAmount(request.amount());
        transaction.setCurrency(request.currency());
        transaction.setPaymentMethod(Transaction.PaymentMethod.valueOf(request.paymentMethod().toUpperCase().replace(" ", "_")));
        transaction.setStatus(Transaction.TransactionStatus.PENDING);
        transaction.setCardLastFour(request.cardNumber().substring(request.cardNumber().length() - 4));
        transaction.setDescription(request.description());

        // Simulate payment processing (in real app, integrate with provider)
        Transaction.TransactionStatus finalStatus = simulatePaymentProcessing(request);
        transaction.setStatus(finalStatus);

        return transactionRepository.save(transaction);
    }

    private Transaction.TransactionStatus simulatePaymentProcessing(PaymentRequestDTO request) {
        // Simple simulation: approve if amount < 1000, else decline
        if (request.amount().compareTo(new java.math.BigDecimal("1000")) < 0) {
            return Transaction.TransactionStatus.APPROVED;
        } else {
            return Transaction.TransactionStatus.DECLINED;
        }
    }
}
