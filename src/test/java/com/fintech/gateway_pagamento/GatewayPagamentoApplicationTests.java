package com.fintech.gateway_pagamento;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class GatewayPagamentoApplicationTests {

	@Test
	void contextLoads() {
	}

}
