CREATE TABLE tb_merchants (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    api_key VARCHAR(255) NOT NULL UNIQUE,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_transactions (
    id BIGSERIAL PRIMARY KEY,
    external_id UUID DEFAULT gen_random_uuid(),
    merchant_id BIGINT NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    payment_method VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    card_last_four VARCHAR(4),
    description VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_transaction_merchant FOREIGN KEY (merchant_id) REFERENCES tb_merchants(id)
);

-- teste
INSERT INTO tb_merchants (name, api_key, status)
VALUES ('Loja teste', 'sk_test_517ghj678', 'ACTIVE');