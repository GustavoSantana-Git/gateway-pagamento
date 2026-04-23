package com.fintech.gateway.repository;

import com.fintech.gateway.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByMerchantId(Long merchantId);

    Optional<Transaction> findByExternalId(UUID externalId);
}
